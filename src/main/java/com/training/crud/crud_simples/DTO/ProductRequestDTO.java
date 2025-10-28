package com.training.crud.crud_simples.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductRequestDTO (
    String name,
    Double price,
    Integer quantity,
    String description){
}
