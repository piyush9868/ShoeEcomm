package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.User;
import jakarta.persistence.*;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.List;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String emailId;
    String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    List<AddressEntity> allAddresses;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    List<OrderEntity> allOrders;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressEntity> getAllAddresses() {
        return allAddresses;
    }

    public void setAllAddresses(List<AddressEntity> allAddresses) {
        this.allAddresses = allAddresses;
    }

    public List<OrderEntity> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<OrderEntity> allOrders) {
        this.allOrders = allOrders;
    }

    public User mapToUser() {
        User user = new User();
        user.setAllAddresses(getAllAddresses());
        user.setAllOrders(getAllOrders());
        user.setEmailId(getEmailId());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setUserId(getUserId());
        return user;
    }
}
