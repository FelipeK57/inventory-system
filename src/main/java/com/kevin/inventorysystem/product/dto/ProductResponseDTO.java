package com.kevin.inventorysystem.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id,
        String sku,
        String name,
        BigDecimal price,
        Boolean isActive,
        LocalDateTime createdAt
) {
}
