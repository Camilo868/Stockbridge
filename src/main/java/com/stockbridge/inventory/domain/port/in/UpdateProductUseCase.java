package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Product;

public interface UpdateProductUseCase {
    Product execute(Long id, String name, String description, String category, Double price, Integer availableQuantity);
}
