package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.enums.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;
    private PaymentMode paymentMode;
}
