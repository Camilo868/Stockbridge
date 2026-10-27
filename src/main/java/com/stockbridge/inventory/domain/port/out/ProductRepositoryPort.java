package com.stockbridge.inventory.domain.port.out;

import com.stockbridge.inventory.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    Optional<Product> findByCode(String code);
    List<Product> findAll();
    List<Product> findByAvailableQuantityLessThan(Integer minQuantity);
    boolean existsByCode(String code);
}
