package com.example.ShoeFactory.entity;

import com.example.ShoeFactory.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(unique = true, nullable = false)
    private String password;

    private String role;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<AddressEntity> allAddresses;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<OrderEntity> allOrders;

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
