package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double productPrice;
    private String productBrand;
    private String createdDate;
    private String material;


    public Products() {
    }
    @ManyToMany
    @JoinTable(
            name = "TeddyBears_Sizes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<Sizes> size = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Images> images = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetails> orderDetail = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "categories_id",referencedColumnName = "id")
    private Categories category;

    public Products(String productName, double productPrice, String productBrand, String createdDate, String material, Categories category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.createdDate = createdDate;
        this.material = material;
        this.category = category;
    }

    public Products(String productName, double productPrice, String productBrand, String createdDate, String material) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.createdDate = createdDate;
        this.material = material;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Long getProductId() {
        return id;
    }

    public void setProductId(Long id) {
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


}
