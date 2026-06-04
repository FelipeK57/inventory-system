package com.kevin.inventorysystem.inventory.service;

import com.kevin.inventorysystem.inventory.entity.InventoryLedger;
import com.kevin.inventorysystem.inventory.repository.JpaInventoryLedgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryLedgerService {

    private final JpaInventoryLedgerRepository jpaInventoryLedgerRepository;

    public List<InventoryLedger> findAll() {
        return jpaInventoryLedgerRepository.findAll();
    }
}
