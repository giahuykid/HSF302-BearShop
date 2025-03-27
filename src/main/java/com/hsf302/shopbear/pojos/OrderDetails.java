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
    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Sizes size;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Colors color;
    public OrderDetails() {
    }

    public OrderDetails(Long id, int quantity, double price, Products product, Orders order, Sizes size, Colors color) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
        this.size = size;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
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
