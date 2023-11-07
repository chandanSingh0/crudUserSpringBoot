package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;


}
