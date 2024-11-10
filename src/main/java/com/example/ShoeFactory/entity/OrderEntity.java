package com.example.ShoeFactory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_table")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_shoe_id")
    private ShoeEntity shoeEntity;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public ShoeEntity getShoeEntity() {
        return shoeEntity;
    }

    public void setShoeEntity(ShoeEntity shoeEntity) {
        this.shoeEntity = shoeEntity;
    }
}
