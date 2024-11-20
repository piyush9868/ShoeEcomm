package com.example.ShoeFactory.entity;

import jakarta.persistence.*;
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
    private Integer price;
}
