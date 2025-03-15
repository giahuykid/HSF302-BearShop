package com.hsf302.shopbear.controller;

        import com.hsf302.shopbear.pojos.Products;
        import com.hsf302.shopbear.pojos.Users;
        import com.hsf302.shopbear.service.AuthService;
        import jakarta.servlet.http.HttpSession;
        import org.apache.catalina.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

        @Controller
        public class AuthController {
            private final AuthService authService;
            private final List<Products> products;


            public AuthController(AuthService authService) {
                this.authService = authService;
                this.products = initializeProducts();
            }

            private List<Products> initializeProducts() {
                List<Products> productList = new ArrayList<>();

                // Create Panda Bear
                Products panda = new Products();
                panda.setProductId(1L);
                panda.setProductName("Giant Panda Bear");
                panda.setProductBrand("BearWorld");
                panda.setProductPrice(399000);
                panda.setMaterial("Premium Plush");
                panda.setCreatedDate("2024-03-20");
                productList.add(panda);

                // Create Freddy Bear
                Products freddy = new Products();
                freddy.setProductId(2L);
                freddy.setProductName("Freddy Bear");
                freddy.setProductBrand("TeddyLux");
                freddy.setProductPrice(299000);
                freddy.setMaterial("Soft Cotton");
                freddy.setCreatedDate("2024-03-20");
                productList.add(freddy);

                return productList;
            }

            @GetMapping("/")
            public String home(@RequestParam(required = false) String search, Model model, HttpSession session) {
                List<Products> filteredProducts = products;
                if (search != null && !search.isEmpty()) {
                    filteredProducts = products.stream()
                            .filter(p -> p.getProductName().toLowerCase().contains(search.toLowerCase()))
                            .collect(Collectors.toList());
                }
                model.addAttribute("products", filteredProducts);
                return "home";
            }

            @GetMapping("/login")
            public String showLoginPage() {
                return "login";
            }

            @PostMapping("/login")
            public String login(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

                Users user = authService.authenticate(username, password);
                if (user != null) {
                    // Store user info in session
                    session.setAttribute("user", user.getUsername());
                    session.setAttribute("role", user.getRole());
                    return "redirect:/";
                } else {
                    model.addAttribute("error", "Invalid username or password");
                    return "login";
                }
            }
            @PostMapping("/logout")
            public String logout(HttpSession session) {
                // Clear session
                session.invalidate();
                return "redirect:/";
            }

            @GetMapping("/profile")
            public String profile(HttpSession session, Model model) {
                String username = (String) session.getAttribute("user");
                if (username == null) {
                    return "redirect:/login";
                }

                if ("admin".equals(username)) {
                    Users adminUser = new Users();
                    adminUser.setUsername("admin");
                    adminUser.setRole("ADMIN");
                    adminUser.setFullName("*****");
                    adminUser.setPhoneNumber("*****");
                    adminUser.setAddress("*****");
                    model.addAttribute("user", adminUser);
                } else {
                    Users user = authService.findByUsername(username);
                    model.addAttribute("user", user);
                }
                return "profile";
            }

            @GetMapping("/product/{id}")
            public String productDetails(@PathVariable Long id, Model model) {
                Products product = products.stream()
                        .filter(p -> p.getProductId().equals(id))
                        .findFirst()
                        .orElse(null);

                if (product == null) {
                    return "redirect:/";
                }

                model.addAttribute("product", product);
                return "product";
            }
        }