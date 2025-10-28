package com.training.crud.crud_simples.DTO;

import com.training.crud.crud_simples.model.ProductModel;

import java.time.LocalDateTime;

public record ProductResponseDTO (

    String name,
    Double price,
    Integer quantity,
    String description,
    LocalDateTime createdAt)
{

    public static ProductResponseDTO fromModel(ProductModel product) {

        return new ProductResponseDTO(
            product.getName(),
            product.getPrice(),
            product.getQuantity(),
            product.getDescription(),
            product.getCreatedAt()
        );
    }
}
