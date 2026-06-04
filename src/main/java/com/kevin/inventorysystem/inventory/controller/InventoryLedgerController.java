package com.kevin.inventorysystem.inventory.controller;

import com.kevin.inventorysystem.inventory.dto.InventoryLedgerResponseDTO;
import com.kevin.inventorysystem.inventory.mapper.InventoryLedgerMapper;
import com.kevin.inventorysystem.inventory.service.InventoryLedgerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory-ledger")
@RequiredArgsConstructor
@Tag(name = "Inventory Ledger", description = "Endpoints for managing inventory ledger")
public class InventoryLedgerController {

    private final InventoryLedgerService inventoryLedgerService;
    private final InventoryLedgerMapper inventoryLedgerMapper;

    @GetMapping
    @Operation(summary = "Get all inventory ledger entries", description = "Retrieves a list of all inventory ledger entries in the system")
    public ResponseEntity<List<InventoryLedgerResponseDTO>> getAll() {
        List<InventoryLedgerResponseDTO> response = inventoryLedgerService.findAll().stream().map(
                inventoryLedgerMapper::toResponseDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
