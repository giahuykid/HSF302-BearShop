package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderDate;
    private String sumPrice;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetails> orderDetail = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payments payment;


    public Orders() {
    }

    public Orders(Long id, String orderDate, String sumPrice, String orderStatus, Users user, Payments payment) {
        this.id = id;

        this.orderDate = orderDate;
        this.sumPrice = sumPrice;
        this.orderStatus = orderStatus;
        this.user = user;
        this.payment = payment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long orderId) {
        this.id = id;
    }


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(String sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


}
