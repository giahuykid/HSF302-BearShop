package com.hsf302.shopbear.pojos;

public class Images {

    private Long imageId;
    private Long productId;
    private String imagePath;

    public Images() {
    }

    public Images(Long imageId, Long productId, String imagePath) {
        this.imageId = imageId;
        this.productId = productId;
        this.imagePath = imagePath;
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
