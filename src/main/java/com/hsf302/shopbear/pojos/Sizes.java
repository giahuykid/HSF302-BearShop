package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sizes")
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeId;
    private Long productId;
    private String sizeName;

    @ManyToMany(mappedBy = "size")
    private Set<Products> teddyBears = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "Sizes_Colors",
            joinColumns = @JoinColumn(name = "size_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<Colors> color = new HashSet<>();

    public Sizes() {
    }

    public Sizes(int sizeId, Long productId, String sizeName) {
        this.sizeId = sizeId;
        this.productId = productId;
        this.sizeName = sizeName;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

}
