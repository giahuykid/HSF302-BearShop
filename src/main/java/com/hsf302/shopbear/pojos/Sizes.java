package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sizes")
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    public Sizes(int id, String sizeName) {
        this.id = id;
        this.sizeName = sizeName;
    }

    public int getSizeId() {
        return id;
    }

    public void setSizeId(int id) {
        this.id = id;
    }


    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

}
