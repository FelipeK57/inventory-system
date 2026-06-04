package com.kevin.inventorysystem.product.controller;

import com.kevin.inventorysystem.product.dto.ProductRequestDTO;
import com.kevin.inventorysystem.product.dto.ProductResponseDTO;
import com.kevin.inventorysystem.product.service.ProductService;
import com.kevin.inventorysystem.product.entity.Product;
import com.kevin.inventorysystem.product.mapper.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Endpoints", description = "Endpoints for managing products in the inventory system")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    @Operation(summary = "Create a new product", description = "Creates a new product in the inventory system")
    public ResponseEntity<ProductResponseDTO> create(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Product details",
            required = true
    ) @RequestBody ProductRequestDTO productRequestDto) {
        Product input = productMapper.toEntity(productRequestDto);
        Product product = productService.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toResponseDto(product));
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all products in the inventory system")
    public ResponseEntity<List<ProductResponseDTO>> getAll() {
        List<ProductResponseDTO> response = productService.findAll().stream().map(productMapper::toResponseDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieves a product by its unique identifier")
    public ResponseEntity<ProductResponseDTO> getById(@Parameter(description = "Product identifier", required = true) @PathVariable Long id) {
        Product product = productService.findById(id);
        ProductResponseDTO response = productMapper.toResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/sku")
    @Operation(summary = "Get product by SKU", description = "Retrieves a product by its Stock Keeping Unit (SKU)")
    public ResponseEntity<List<ProductResponseDTO>> getBySku(@Parameter(description = "Product SKU", required = true) @RequestParam String sku) {
        Product product = productService.findBySku(sku);
        ProductResponseDTO response = productMapper.toResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(List.of(response));
    }

    @PutMapping
    @Operation(summary = "Update a product", description = "Updates the details of an existing product in the inventory system")
    public ResponseEntity<ProductResponseDTO> update(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Updated product details",
            required = true
    ) @RequestBody ProductRequestDTO productRequestDto, @Parameter(description = "Product identifier", required = true) @RequestParam Long id) {
        Product input = productMapper.toEntity(productRequestDto);
        Product product = productService.update(id, input);
        return ResponseEntity.status(HttpStatus.OK).body(productMapper.toResponseDto(product));
    }

    @PostMapping("/status")
    @Operation(description = "Changes the active status of a product. If the product is currently active, it will be deactivated, and if it is currently inactive, it will be activated.")
    public ResponseEntity<ProductResponseDTO> changeStatus(@Parameter(description = "Product identifier", required = true) @RequestParam Long id) {
        Product product = productService.changeStatus(id);
        ProductResponseDTO response = productMapper.toResponseDto(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
