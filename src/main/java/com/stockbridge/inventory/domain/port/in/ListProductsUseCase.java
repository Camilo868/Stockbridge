package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Product;
import java.util.List;

public interface ListProductsUseCase {
    List<Product> getAll();
    List<Product> getWithLowStock(Integer minStock);
}
