package com.kevin.inventorysystem.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InventoryLedgerResponseDTO(
        Long id,
        String movementType,
        int quantity,
        BigDecimal unitPrice,
        String reference,
        LocalDateTime createdAt
) {
}
