package com.stockbridge.inventory.domain.port.in;

import com.stockbridge.inventory.domain.model.Request;
import com.stockbridge.inventory.domain.model.RequestStatus;
import java.util.List;

public interface ListRequestsUseCase {
    List<Request> getAll();
    List<Request> getByUserId(Long userId);
    List<Request> getByStatus(RequestStatus status);
}
