package com.training.crud.crud_simples.DTO;

import java.time.LocalDateTime;

public record ErrorResponseDTO (String error, String detail, LocalDateTime time) {
}
