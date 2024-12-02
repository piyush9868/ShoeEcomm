package com.example.ShoeFactory.model;

import com.example.ShoeFactory.entity.ShoeEntity;
import lombok.Data;

@Data
public class Shoe {
    private String name;
    private String brand;
    private String category;
    private Float size;
    private String color;
    private Double price;
    private Integer stockQuantity;
    private String description;
    private String material;
    private Float ratings;
    private String imageUrl;

    public ShoeEntity mapDataObjToEntity() {
        ShoeEntity shoeEntity = new ShoeEntity();
        shoeEntity.setName(name);
        shoeEntity.setBrand(brand);
        shoeEntity.setCategory(category);
        shoeEntity.setSize(size);
        shoeEntity.setColor(color);
        shoeEntity.setPrice(price);
        shoeEntity.setStockQuantity(stockQuantity);
        shoeEntity.setDescription(description);
        shoeEntity.setMaterial(material);
        shoeEntity.setRatings(ratings);
        shoeEntity.setImageUrl(imageUrl);
        return shoeEntity;
    }
}
