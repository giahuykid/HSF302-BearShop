package com.hsf302.shopbear.pojos;

public class Colors {

    private int colorId;
    private int sizeId;
    private String colorName;

    public Colors() {
    }

    public Colors(int colorId, int sizeId, String colorName) {
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.colorName = colorName;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

}
