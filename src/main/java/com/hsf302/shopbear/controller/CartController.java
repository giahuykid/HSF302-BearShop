//package com.hsf302.shopbear.controller;
//
//import com.hsf302.shopbear.pojos.Products;
//import com.hsf302.shopbear.service.ProductService;
//import jakarta.servlet.http.HttpSession;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/cart")
//public class CartController {
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping
//    public String viewCart(Model model, HttpSession session) {
//        String username = (String) session.getAttribute("user");
//        if (username == null) {
//            return "redirect:/login";
//        }
//        @SuppressWarnings("unchecked")
//        List<Products> cartItems = (List<Products>) session.getAttribute("cartItems");
//        if (cartItems == null) {
//            cartItems = new ArrayList<>();
//            session.setAttribute("cartItems", cartItems);
//        }
//        model.addAttribute("cartItems", cartItems);
//        return "cart";
//    }
//
//    @PostMapping("/add")
//    public String addToCart(@RequestParam Long productId, HttpSession session) {
//        String username = (String) session.getAttribute("user");
//        if (username == null) {
//            return "redirect:/login";
//        }
//
//        Products product = productService.findById(productId);
//        if (product != null) {
//            @SuppressWarnings("unchecked")
//            List<Products> cartItems = (List<Products>) session.getAttribute("cartItems");
//            if (cartItems == null) {
//                cartItems = new ArrayList<>();
//            }
//            cartItems.add(product);
//            session.setAttribute("cartItems", cartItems);
//            session.setAttribute("cartCount", cartItems.size());
//        }
//        return "redirect:/product/" + productId;
//    }
//    @PostMapping("/cart/add")
//    public String addToCart(@RequestParam Long productId,
//                           @RequestParam(defaultValue = "1") int quantity,
//                           HttpSession session) {
//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            return "redirect:/login";
//        }
//
//        @SuppressWarnings("unchecked")
//        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new ArrayList<>();
//        }
//
//        // Find existing cart item
//        Optional<CartItem> existingItem = cart.stream()
//            .filter(item -> item.getProductId().equals(productId))
//            .findFirst();
//
//        if (existingItem.isPresent()) {
//            // Update quantity if item exists
//            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
//        } else {
//            // Add new item if it doesn't exist
//            Product product = productService.findById(productId);
//            CartItem newItem = new CartItem();
//            newItem.setProductId(productId);
//            newItem.setProductName(product.getProductName());
//            newItem.setProductPrice(product.getProductPrice());
//            newItem.setQuantity(quantity);
//            newItem.setProductImage(product.getProductName() + ".jpg");
//            cart.add(newItem);
//        }
//
//        session.setAttribute("cart", cart);
//        session.setAttribute("cartCount", cart.stream().mapToInt(CartItem::getQuantity).sum());
//
//        return "redirect:/";
//    }
//}
