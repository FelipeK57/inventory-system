package com.kevin.inventorysystem.inventory.mapper;

import com.kevin.inventorysystem.inventory.dto.InventoryLedgerResponseDTO;
import com.kevin.inventorysystem.inventory.entity.InventoryLedger;
import org.springframework.stereotype.Component;

@Component
public class InventoryLedgerMapper {

    public InventoryLedgerResponseDTO toResponseDto(InventoryLedger inventoryLedger) {
        if (inventoryLedger == null) {
            return null;
        }

        return new InventoryLedgerResponseDTO(
                inventoryLedger.getId(),
                inventoryLedger.getMovementType(),
                inventoryLedger.getQuantity(),
                inventoryLedger.getUnitCost(),
                inventoryLedger.getReference(),
                inventoryLedger.getCreatedAt()
        );
    }
}
