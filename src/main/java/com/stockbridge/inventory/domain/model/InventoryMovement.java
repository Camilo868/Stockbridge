package com.stockbridge.inventory.domain.model;

import com.stockbridge.inventory.domain.exception.InvalidMovementException;
import java.time.LocalDateTime;

public class InventoryMovement {
    private Long id;
    private String productCode;
    private MovementType type;
    private Integer quantity;
    private String reason;
    private Long performedByUserId;
    private Long requestId; // Referencia opcional si el movimiento proviene de una solicitud
    private LocalDateTime timestamp;

    public InventoryMovement(String productCode, MovementType type, Integer quantity, String reason, Long performedByUserId, Long requestId) {
        if (productCode == null || productCode.trim().isEmpty()) {
            throw new InvalidMovementException("El código de producto es obligatorio.");
        }
        if (type == null) {
            throw new InvalidMovementException("El tipo de movimiento es obligatorio.");
        }
        if (quantity == null || quantity <= 0) {
            throw new InvalidMovementException("La cantidad del movimiento debe ser mayor a cero.");
        }
        if (performedByUserId == null) {
            throw new InvalidMovementException("El usuario responsable del movimiento es obligatorio.");
        }

        this.productCode = productCode;
        this.type = type;
        this.quantity = quantity;
        this.reason = reason;
        this.performedByUserId = performedByUserId;
        this.requestId = requestId;
        this.timestamp = LocalDateTime.now();
    }

    public InventoryMovement(String productCode, MovementType type, Integer quantity, String reason, Long performedByUserId) {
        this(productCode, type, quantity, reason, performedByUserId, null);
    }

    public InventoryMovement(Long id, String productCode, MovementType type, Integer quantity, String reason, Long performedByUserId, Long requestId, LocalDateTime timestamp) {
        this.id = id;
        this.productCode = productCode;
        this.type = type;
        this.quantity = quantity;
        this.reason = reason;
        this.performedByUserId = performedByUserId;
        this.requestId = requestId;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getProductCode() {
        return productCode;
    }

    public MovementType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getReason() {
        return reason;
    }

    public Long getPerformedByUserId() {
        return performedByUserId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
