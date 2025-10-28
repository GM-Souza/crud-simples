package com.training.crud.crud_simples.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tb_product")
@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Double price;

    private Integer quantity;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name ="created_at", nullable = false)
    private LocalDateTime createdAt;
}
