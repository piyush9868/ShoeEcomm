package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_shoe_join",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "shoe_id")
    )
    private List<ShoeEntity> shoeEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private UserEntity userEntity;

    private int orderTotal;
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_payment_id")
    private PaymentEntity paymentEntity;
    private String invoiceLink;

    @Temporal(TemporalType.DATE)
    private Date orderTimeStamp;

}
