package com.example.orderservice.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor // meaning is include No Argument constructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private int quantity;

    private double price;

  
}
