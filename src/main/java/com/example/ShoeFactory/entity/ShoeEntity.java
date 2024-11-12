package com.example.ShoeFactory.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "shoe_table")
public class ShoeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
