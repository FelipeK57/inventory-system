package com.kevin.inventorysystem.product.controller;

import com.kevin.inventorysystem.product.dto.ProductRequestDto;
import com.kevin.inventorysystem.product.dto.ProductResponseDTO;
import com.kevin.inventorysystem.product.service.ProductService;
import com.kevin.inventorysystem.product.entity.Product;
import com.kevin.inventorysystem.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDto productRequestDto) {
        Product input = productMapper.toEntity(productRequestDto);
        Product product = productService.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toResponseDto(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> response = productService.findAll().stream().map(productMapper::toResponseDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductResponseDTO response = productMapper.toResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/sku")
    public ResponseEntity<List<ProductResponseDTO>> getBySku(@RequestParam String sku) {
        Product product = productService.findBySku(sku);
        ProductResponseDTO response = productMapper.toResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(List.of(response));
    }
}
