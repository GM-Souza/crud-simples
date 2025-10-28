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

        ProductModel productModel = new ProductModel();
        productModel.setName(productDTO.name());
        productModel.setPrice(productDTO.price());
        productModel.setQuantity(productDTO.quantity());
        productModel.setDescription(productDTO.description());
        productModel.setCreatedAt(LocalDateTime.now());

        if(productDTO.name().isBlank()){
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }

        if(productRepository.findByName(productDTO.name()).isPresent()) {
            throw new EqualNameException("Esse produto já existe.");
        }

        productRepository.save(productModel);

        return ProductResponseDTO.fromModel(productModel);
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductModel productModel = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + id));

        return ProductResponseDTO.fromModel(productModel);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productDTO) {

        ProductModel productModel = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + id));

        if (productDTO.name() != null && !productDTO.name().isBlank() &&
                !Objects.equals(productModel.getName(), productDTO.name())) {
            if (productRepository.findByName(productDTO.name()).isPresent()) {
                throw new EqualNameException("Esse produto já existe.");
            }
            productModel.setName(productDTO.name());
        }

        if (productDTO.price() != null) {
            productModel.setPrice(productDTO.price());
        }

        if (productDTO.quantity() != null) {
            productModel.setQuantity(productDTO.quantity());
        }

        if (productDTO.description() != null) {
            productModel.setDescription(productDTO.description());
        }

        productRepository.save(productModel);

        return ProductResponseDTO.fromModel(productModel);
    }

    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado com o ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
