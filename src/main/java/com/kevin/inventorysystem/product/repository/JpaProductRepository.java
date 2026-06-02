package com.kevin.inventorysystem.product.repository;

import com.kevin.inventorysystem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySku(String sku);
}
