package com.hsf302.shopbear.controller;

import com.hsf302.shopbear.pojos.Categories;
import com.hsf302.shopbear.pojos.Products;
import com.hsf302.shopbear.repositories.CategoryRepository;
import com.hsf302.shopbear.repositories.ProductRepository;
import com.hsf302.shopbear.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ProductControllerIMPL{
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository CategoryRepository;


    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("categories", CategoryRepository.findAll());
        return "CreateProduct";
    }

    @PostMapping("/products/createProduct")
    public String createProduct(
            @ModelAttribute Products product,
            @RequestParam("image") MultipartFile imageFile,
            RedirectAttributes redirectAttributes) {
        try {
            productService.createProduct(product, imageFile); // Xử lý ảnh trong Service
            redirectAttributes.addFlashAttribute("message", "Product created successfully!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Failed to process image");
        }
        return "redirect:/products/list";
    }

    @GetMapping("/products/list")
    public String showProductList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "ListProduct";
    }

}
