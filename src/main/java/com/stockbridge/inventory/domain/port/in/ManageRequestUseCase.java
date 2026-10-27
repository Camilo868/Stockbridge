package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Request;

public interface ManageRequestUseCase {
    Request approve(Long requestId);
    Request reject(Long requestId, String reason);
    Request deliver(Long requestId, Long deliveredByUserId);
    Request cancel(Long requestId, Long requestingUserId, boolean isAdmin);
}
