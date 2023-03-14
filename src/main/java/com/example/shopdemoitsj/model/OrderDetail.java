package com.example.shopdemoitsj.model;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;

    private int quantity;

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
