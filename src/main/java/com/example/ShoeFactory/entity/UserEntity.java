package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.List;

@Entity
@Table(name = "user_table")
@Data
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
