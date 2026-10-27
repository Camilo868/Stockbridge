package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Request;

public interface CreateRequestUseCase {
    Request execute(Long userId, String productCode, Integer quantity, String observation);
}
