package com.kevin.inventorysystem.inventory.repository;

import com.kevin.inventorysystem.inventory.entity.InventoryLedger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInventoryLedgerRepository extends JpaRepository<InventoryLedger, Long> {
    
}
