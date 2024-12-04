package org.example;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int quantity;

    String unitOfMeasurement;

    public Ingredient() {

    }

    public Ingredient(String name, int quantity, String unitOfMeasurement) {
        this.name = name;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                '}';
    }
}
