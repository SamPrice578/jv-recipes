package org.example;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String filename;

    private byte[] fileData;

    @ManyToOne
    private Recipe associatedRecipe;

    public Image(String filename, byte[] fileData, Recipe associatedRecipe) {

        this.filename = filename;
        this.fileData = fileData;
        this.associatedRecipe = associatedRecipe;
    }

    public Image() {
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", fileData=" + Arrays.toString(fileData) +
                ", associatedRecipe=" + associatedRecipe +
                '}';
    }
}
