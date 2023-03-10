package com.example.technologies.model;

public class Punch {

    private double diameter;
    private double quantity_in_the_matrix;
    private double feed;

    public Punch(double diameter, double quantity_in_the_matrix, double feed) {
        this.diameter = diameter;
        this.quantity_in_the_matrix = quantity_in_the_matrix;
        this.feed = feed;
    }

    @Override
    public String toString() {
        return "Punch{" +
                "diameter=" + diameter +
                ", quantity_in_the_matrix=" + quantity_in_the_matrix +
                ", feed=" + feed +
                '}';
    }
}
