package com.training.crud.crud_simples.DTO;

public record ProductRequestDTO (
    String name,
    Double price,
    Integer quantity,
    String description){

    public ProductRequestDTO(String name, String description){
        this(name, null, null, description);
    }
}
