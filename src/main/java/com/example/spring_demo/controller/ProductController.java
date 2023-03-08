package com.example.spring_demo.controller;

import com.example.spring_demo.dto.ProductDto;
import com.example.spring_demo.model.Product;
import com.example.spring_demo.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> new ProductDto(product.getModel(), product.getDescription(), product.isModelNew())).toList();
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product, "id");
        productRepository.save(product);
        return ResponseEntity.ok("Product saved");
    }
}
