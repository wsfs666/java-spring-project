package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;

    public Student(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    @JsonIgnore  // no return name value to frontend
    public String getName() {
        return name;
    }
}
