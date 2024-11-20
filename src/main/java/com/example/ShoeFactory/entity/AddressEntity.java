package com.example.ShoeFactory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address_table")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String address;
    String landmark;
    Long contactNumber;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    UserEntity userEntity;
}
