package com.leaveplanner.domain;

import java.time.LocalDate;

public class User {

    private Long id;
    private final String name;
    private final String email;
    private final LocalDate enlistmentDate;
    private final LocalDate createdAt;

    public User(
        Long id,
        String name,
        String email,
        LocalDate enlistmentDate,
        LocalDate createdAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enlistmentDate = enlistmentDate;
        this.createdAt = createdAt;
    }

    public void assignId(Long id) {
        if (this.id != null) {
            throw new IllegalStateException("Id는 한번만 할당");
        }
        this.id = id;
    }

    public LocalDate getEnlistmentDate() {
        return enlistmentDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public LocalDate getCreatedAt() {
        return createdAt;
    }
}