package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "Payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentType;
    private String paymentStatus;
    private String paymentLocation;

    @OneToOne(mappedBy = "payment")
    private Orders order;

    public Payments() {
    }

    public Payments(Long id, String paymentType, String paymentStatus, String paymentLocation, Orders order) {
        this.id = id;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentLocation = paymentLocation;
        this.order = order;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Long getPaymentId() {
        return id;
    }

    public void setPaymentId(Long paymentId) {
        this.id = id;
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
