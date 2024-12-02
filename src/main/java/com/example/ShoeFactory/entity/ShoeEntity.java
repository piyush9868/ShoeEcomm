package com.example.ShoeFactory.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "shoe_table")
@Data
public class ShoeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String brand;
    private String category;
    private Float size;
    private String color;
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    private String description;
    private String material;
    private Float ratings;
    private String imageUrl;
}
