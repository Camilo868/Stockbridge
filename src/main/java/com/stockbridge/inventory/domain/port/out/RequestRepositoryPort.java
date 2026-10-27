package com.stockbridge.inventory.domain.port.out;

import com.stockbridge.inventory.domain.model.Request;
import com.stockbridge.inventory.domain.model.RequestStatus;
import java.util.List;
import java.util.Optional;

public interface RequestRepositoryPort {
    Request save(Request request);
    Optional<Request> findById(Long id);
    List<Request> findAll();
    List<Request> findByUserId(Long userId);
    List<Request> findByStatus(RequestStatus status);
}
