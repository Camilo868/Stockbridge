package com.stockbridge.inventory.domain.model;

import com.stockbridge.inventory.domain.exception.InvalidRequestException;
import com.stockbridge.inventory.domain.exception.InvalidRequestStateException;
import java.time.LocalDateTime;

public class Request {
    private Long id;
    private Long userId;
    private String productCode;
    private Integer quantity;
    private LocalDateTime createdAt;
    private RequestStatus status;
    private String observation;

    public Request(Long userId, String productCode, Integer quantity, String observation) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidRequestException("La cantidad solicitada debe ser mayor a cero.");
        }
        if (userId == null || productCode == null || productCode.trim().isEmpty()) {
            throw new InvalidRequestException("El usuario y el producto son obligatorios.");
        }

        this.userId = userId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.observation = observation;
        this.createdAt = LocalDateTime.now();
        this.status = RequestStatus.PENDIENTE;
    }

    public Request(Long id, Long userId, String productCode, Integer quantity, LocalDateTime createdAt, RequestStatus status, String observation) {
        this.id = id;
        this.userId = userId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.status = status;
        this.observation = observation;
    }

    public void approve() {
        if (this.status != RequestStatus.PENDIENTE) {
            throw new InvalidRequestStateException("Solo las solicitudes pendientes pueden ser aprobadas.");
        }
        this.status = RequestStatus.APROBADA;
    }

    public void reject(String reason) {
        if (this.status != RequestStatus.PENDIENTE) {
            throw new InvalidRequestStateException("Solo las solicitudes pendientes pueden ser rechazadas.");
        }
        this.status = RequestStatus.RECHAZADA;
        this.observation = reason;
    }

    public void deliver() {
        if (this.status != RequestStatus.APROBADA) {
            throw new InvalidRequestStateException("Solo las solicitudes aprobadas pueden ser entregadas.");
        }
        this.status = RequestStatus.ENTREGADA;
    }

    public void cancel() {
        if (this.status == RequestStatus.ENTREGADA || this.status == RequestStatus.RECHAZADA) {
            throw new InvalidRequestStateException("No se puede cancelar una solicitud que ya fue entregada o rechazada.");
        }
        this.status = RequestStatus.CANCELADA;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getProductCode() { return productCode; }
    public Integer getQuantity() { return quantity; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public RequestStatus getStatus() { return status; }
    public String getObservation() { return observation; }
}