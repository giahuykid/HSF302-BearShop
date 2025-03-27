package com.hsf302.shopbear.controller;

        import com.hsf302.shopbear.pojos.Products;
        import com.hsf302.shopbear.pojos.Users;
        import com.hsf302.shopbear.service.AuthService;
        import com.hsf302.shopbear.service.ProductService;
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
            private final ProductService productService;

            @Autowired
            public AuthController(AuthService authService, ProductService productService) {
                this.authService = authService;
                this.productService = productService;
            }

            @GetMapping("/")
            public String home(@RequestParam(required = false) String search, Model model, HttpSession session) {
                List<Products> products;
                if (search != null && !search.trim().isEmpty()) {
                    products = productService.findByProductNameContaining(search);
                } else {
                    products = productService.getAllProducts();
                }
                model.addAttribute("products", products);
                model.addAttribute("search", search); // Preserve search term
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
                    session.setAttribute("user", user.getUsername());
                    session.setAttribute("role", user.getRole());
                    return "redirect:/";
                }
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }

            @PostMapping("/logout")
            public String logout(HttpSession session) {
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
                Products product = productService.findById(id);
                if (product == null) {
                    return "redirect:/";
                }
                model.addAttribute("product", product);
                return "product";
            }
        }