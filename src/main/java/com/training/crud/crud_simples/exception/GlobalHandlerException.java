package com.training.crud.crud_simples.exception;

import com.training.crud.crud_simples.DTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                ex.getMessage(),
                "Nome do produto inválido. Verifique o valor e tente novamente.",
                java.time.LocalDateTime.now()
        );

        return errorResponseDTO;
    }

    @ExceptionHandler(EqualNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleEqualNameException(EqualNameException ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                ex.getMessage(),
                "Já existe um produto com esse nome. Por favor, escolha um nome diferente.",
                java.time.LocalDateTime.now()
        );
        return errorResponseDTO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleGeneralException(Exception ex) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                ex.getMessage(),
                "Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.",
                java.time.LocalDateTime.now());
    return errorResponseDTO;
    }

}