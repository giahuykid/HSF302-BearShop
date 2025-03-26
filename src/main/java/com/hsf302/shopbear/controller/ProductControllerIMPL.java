package com.hsf302.shopbear.controller;

import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductControllerIMPL implements ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/manageProduct")
    public ModelAndView manageProduct() {
        ModelAndView modelAndView = new ModelAndView("manageProductjsp");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }


    @Override
    @PostMapping("/manageProductaction")
    public String manageProduct(HttpServletRequest request) {
        String action = request.getParameter("btnManageProduct");
        String productName = request.getParameter("txtproductName");
        String productPriceStr = request.getParameter("txtproductPrice");
        double productPrice = 0.0;

        if (productPriceStr != null && !productPriceStr.isEmpty()) {
            try {
                productPrice = Double.parseDouble(productPriceStr);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá sản phẩm không hợp lệ!");
            }
        }

        String productBrand = request.getParameter("txtproductBrand");
        String createdDate = request.getParameter("txtcreatedDate");
        String material = request.getParameter("txtmaterial");
        Products product = new Products(productName,productPrice,productBrand,createdDate,material);
        switch (action) {
            case "add":
                productService.createProduct(product);
                break;
            case "update":
                productService.updateProduct(product);
                break;
            case "delete":
                productService.deleteProduct(product.getProductId());
                break;

        }
        return "redirect:/manageProduct";
    }
}
