package com.stockbridge.inventory.domain.model;

import com.stockbridge.inventory.domain.exception.InvalidProductException;
import com.stockbridge.inventory.domain.exception.InsufficientStockException;

public class Product {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer availableQuantity;
    private Boolean active;

    public Product(String code, String name, String description, String category, Double price, Integer availableQuantity) {
        if (price == null || price <= 0) {
            throw new InvalidProductException("El precio debe ser mayor que cero.");
        }
        if (availableQuantity == null || availableQuantity < 0) {
            throw new InvalidProductException("Las existencias no pueden ser negativas.");
        }

        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.active = true;
    }

    public Product(Long id, String code, String name, String description, String category, Double price, Integer availableQuantity, Boolean active) {
        this(code, name, description, category, price, availableQuantity);
        this.id = id;
        this.active = active;
    }

    public void decreaseStock(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new InvalidProductException("La cantidad a descontar debe ser mayor a cero.");
        }
        if (this.availableQuantity < quantity) {
            throw new InsufficientStockException("No hay existencias suficientes para la solicitud.");
        }
        this.availableQuantity -= quantity;
    }

    public void activate() { this.active = true; }
    public void deactivate() { this.active = false; }

    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public Double getPrice() {
        return price;
    }
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }
    public Boolean getActive() {
        return active;
    }
}