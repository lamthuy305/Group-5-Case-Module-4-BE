package com.example.casemodule4group5.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String img; // 1 ảnh đại diện món ăn

    private String description;

    private double price;

    private double salePrice;

    private double serviceFee;

    private String dayCreate;

    private String dayChange;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "food_tag")
    private Set<Tag> tag;

    private Long countViews;

    private Long countBuys;

    @ManyToOne
    private User user;

    public Food(Long id, String name, String img, String description, double price, double salePrice, double serviceFee, String dayCreate, String dayChange, Long countViews, Long countBuys) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.salePrice = salePrice;
        this.serviceFee = serviceFee;
        this.dayCreate = dayCreate;
        this.dayChange = dayChange;
        this.countViews = countViews;
        this.countBuys = countBuys;
    }
}
