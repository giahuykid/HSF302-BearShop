package com.hsf302.shopbear.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order ;

    public OrderDetails() {
    }

    public OrderDetails( int quantity, double price, Products products, Orders orders) {

        this.quantity = quantity;
        this.price = price;
        this.product = products;
        this.order = orders;
    }

    public Products getProducts() {
        return product;
    }

    public void setProducts(Products products) {
        this.product = products;
    }

    public Orders getOrders() {
        return order;
    }

    public void setOrders(Orders orders) {
        this.order = orders;
    }

    public Long getOrderDetailId() {
        return id;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
