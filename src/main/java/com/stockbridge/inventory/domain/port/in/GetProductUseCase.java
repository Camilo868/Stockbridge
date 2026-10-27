package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Product;

public interface GetProductUseCase {
    Product getById(Long id);
    Product getByCode(String code);
}
