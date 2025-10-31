package com.training.crud.crud_simples.DTO;

import com.training.crud.crud_simples.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
