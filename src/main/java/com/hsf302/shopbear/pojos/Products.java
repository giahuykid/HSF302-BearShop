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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Categories> category = new HashSet<>();



    public Products(String productName, double productPrice, String productBrand, String createdDate, String material) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.createdDate = createdDate;
        this.material = material;
    }

    public Set<Sizes> getSize() {
        return size;
    }

    public void setSize(Set<Sizes> size) {
        this.size = size;
    }

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public Set<OrderDetails> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetails> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Set<Categories> getCategory() {
        return category;
    }

    public void setCategory(Set<Categories> category) {
        this.category = category;
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
