package com.stockbridge.inventory.domain.model;

import com.stockbridge.inventory.domain.exception.InvalidUserException;

public class User {
    private Long id;
    private String email;
    private String password;
    private Role role;
    private Boolean active;


    public User(String email, String password, Role role) {
        if (email == null || email.trim().isEmpty()) {
            throw new InvalidUserException("El correo electrónico es obligatorio.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new InvalidUserException("La contraseña es obligatoria.");
        }
        if (role == null) {
            throw new InvalidUserException("El rol del usuario es obligatorio.");
        }

        this.email = email;
        this.password = password;
        this.role = role;
        this.active = true;
    }

    public User(Long id, String email, String password, Role role, Boolean active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public void deactivate() {
        this.active = false;
    }

    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    public Boolean getActive() {
        return active;
    }
}