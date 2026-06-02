package com.kevin.inventorysystem.product.dto;

import java.math.BigDecimal;

public record ProductRequestDto(
        String sku,
        String name,
        BigDecimal price
) {
}
