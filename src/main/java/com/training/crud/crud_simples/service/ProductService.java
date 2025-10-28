package com.training.crud.crud_simples.service;

import com.training.crud.crud_simples.DTO.ProductRequestDTO;
import com.training.crud.crud_simples.DTO.ProductResponseDTO;

import com.training.crud.crud_simples.exception.EqualNameException;
import com.training.crud.crud_simples.model.ProductModel;
import com.training.crud.crud_simples.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productDTO) {

        if(productDTO.name().isBlank()){
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }
        ProductModel productModel = new ProductModel();
        productModel.setName(productDTO.name());
        productModel.setPrice(productDTO.price());
        productModel.setQuantity(productDTO.quantity());
        productModel.setDescription(productDTO.description());
        productModel.setCreatedAt(LocalDateTime.now());

        if(productRepository.findByName(productDTO.name()).isPresent()) {
            throw new EqualNameException("Já existe um produto com esse nome: " + productDTO.name());
        }

        productRepository.save(productModel);

        return ProductResponseDTO.fromModel(productModel);
    }
}
