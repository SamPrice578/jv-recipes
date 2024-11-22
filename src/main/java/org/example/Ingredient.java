package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Ingredient {

    @Id
    int id;

    String name;

    int quantity;

    String unitOfMeasurement;

    public Ingredient() {

    }

    public Ingredient(int id, String name, int quantity, String unitOfMeasurement) {
        this.id = id;
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
