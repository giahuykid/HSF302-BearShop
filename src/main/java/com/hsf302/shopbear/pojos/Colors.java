package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Colors")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String colorName;


    public Colors() {
    }

    public Colors(int id, String colorName) {
        this.id = id;

        this.colorName = colorName;
    }

    public int getColorId() {
        return id;
    }

    public void setColorId(int id) {
        this.id = id;
    }


    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

}
