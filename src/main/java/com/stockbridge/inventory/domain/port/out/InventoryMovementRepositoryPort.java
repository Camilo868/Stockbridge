package com.stockbridge.inventory.domain.port.out;

import com.stockbridge.inventory.domain.model.InventoryMovement;
import java.util.List;

public interface InventoryMovementRepositoryPort {
    InventoryMovement save(InventoryMovement movement);
    List<InventoryMovement> findByProductCode(String productCode);
    List<InventoryMovement> findAll();
}
