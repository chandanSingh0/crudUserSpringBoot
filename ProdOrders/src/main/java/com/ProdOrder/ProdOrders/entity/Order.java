package com.ProdOrder.ProdOrders.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_Id")
    int OrderId;
    @Column(name = "Order_Amount")
    String amount;
    @Column(name = "Order_Date")
    LocalDate orderDate;

    @OneToMany
    @JoinColumn(name = "Order_Id")
    List<Product> products;
}
