package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "Images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private Long productId;
    private String imagePath;

    public Images() {
    }
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    public Images(Long imageId, Long productId, String imagePath, Products product) {
        this.imageId = imageId;
        this.productId = productId;
        this.imagePath = imagePath;
        this.product = product;
    }

    public Images(Long imageId, Long productId, String imagePath) {
        this.imageId = imageId;
        this.productId = productId;
        this.imagePath = imagePath;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
