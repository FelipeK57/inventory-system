package com.kevin.inventorysystem.product.dto;

import java.time.LocalDateTime;

public record ProductResponseDTO(
        Long id,
        String sku,
        String name,
        Boolean isActive,
        LocalDateTime createdAt
) {
}
