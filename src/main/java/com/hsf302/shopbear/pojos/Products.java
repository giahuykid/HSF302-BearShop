package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double productPrice;
    private String productBrand;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Định dạng ngày tháng

    private LocalDate createdDate;
    private String material;
    private String status;


    public Products() {
    }
    private String imagePath; // Lưu đường dẫn ảnh


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetails> orderDetail = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Categories> categories = new HashSet<>();

    public Products(Long id, String productName, double productPrice, String productBrand, LocalDate createdDate, String material, String status, String imagePath) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.createdDate = createdDate;
        this.material = material;
        this.status = status;
        this.imagePath = imagePath;
    }

    public String getStatus() {
        return status;
    }



    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Set<OrderDetails> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetails> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }



    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


}
