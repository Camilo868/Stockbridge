package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Request;

public interface GetRequestUseCase {
    Request execute(Long requestId);
}
