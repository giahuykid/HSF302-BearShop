package com.hsf302.shopbear.pojos;

public class Sizes {

    private int sizeId;
    private Long productId;
    private String sizeName;

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
