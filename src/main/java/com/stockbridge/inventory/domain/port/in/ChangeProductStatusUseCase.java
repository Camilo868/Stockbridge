package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Product;

public interface ChangeProductStatusUseCase {
    Product activate(Long id);
    Product deactivate(Long id);
}
