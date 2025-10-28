package com.training.crud.crud_simples.controller;

import com.training.crud.crud_simples.DTO.ProductRequestDTO;
import com.training.crud.crud_simples.DTO.ProductResponseDTO;
import com.training.crud.crud_simples.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
       ProductResponseDTO newProduct = productService.createProduct(productRequestDTO);
       return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/{id}")
        public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
            ProductResponseDTO product = productService.getProductById(id);
            return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
        public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
            ProductResponseDTO updatedProduct = productService.updateProduct(id, productRequestDTO);
            return ResponseEntity.ok(updatedProduct);
    }
}
