package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.InventoryMovement;
import java.util.List;

public interface ListMovementsUseCase {
    List<InventoryMovement> getAll();
    List<InventoryMovement> getByProductCode(String productCode);
}
