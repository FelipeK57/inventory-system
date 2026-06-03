package com.kevin.inventorysystem.product.service;

import com.kevin.inventorysystem.product.entity.Product;
import com.kevin.inventorysystem.product.repository.JpaProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final JpaProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        if (productRepository.findBySku(product.getSku()).isPresent()) {
            throw new IllegalArgumentException("Product with SKU already exists");
        }
        product.setIsActive(true);
        product.setCreatedAt(LocalDateTime.now());

        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " does not exist"));
    }

    public Product findBySku(String sku) {
        return productRepository.findBySku(sku).orElseThrow(() -> new IllegalArgumentException("Product with SKU " + sku + " does not exist"));
    }

    public Product update(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " does not exist"));

        existingProduct.setSku(product.getSku());
        existingProduct.setName(product.getName());

        return productRepository.save(existingProduct);
    }

    public Product changeStatus(Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " does not exist"));

        existingProduct.setIsActive(!existingProduct.getIsActive());

        return productRepository.save(existingProduct);
    }
}
