package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payment_table")
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private String id;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode")
    private PaymentMode paymentMode;
}
