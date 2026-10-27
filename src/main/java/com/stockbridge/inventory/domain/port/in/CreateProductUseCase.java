package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Product;

public interface CreateProductUseCase {
    Product execute(String code, String name, String description, String category, Double price, Integer availableQuantity);
}
