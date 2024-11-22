package org.example;

import jakarta.persistence.Entity;

@Entity
class Category {

    int id;

    String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
