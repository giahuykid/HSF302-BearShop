package com.hsf302.shopbear.pojos;

public class Payments {

    private Long paymentId;
    private Long orderId;
    private String paymentType;
    private String paymentStatus;
    private String paymentLocation;

    public Payments() {
    }

    public Payments(Long paymentId, Long orderId, String paymentType, String paymentStatus, String paymentLocation) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentLocation = paymentLocation;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentLocation() {
        return paymentLocation;
    }

    public void setPaymentLocation(String paymentLocation) {
        this.paymentLocation = paymentLocation;
    }

}
