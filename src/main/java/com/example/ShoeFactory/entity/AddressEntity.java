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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
