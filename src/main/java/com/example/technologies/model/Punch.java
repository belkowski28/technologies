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

    private double kszt_h (){
        return ((300*this.quantity_in_the_matrix)*60)/1000;
    }

    private double mb_kszt(){
        //return (this.quantity_in_the_matrix/(this.feed/1000))/1000;
        return Math.round(((this.quantity_in_the_matrix/(this.feed/1000))/1000)*1000.0)/1000.0;
    }


    @Override
    public String toString() {
        return "Punch{" +
                "diameter= " + diameter +
                ", quantity_in_the_matrix= " + quantity_in_the_matrix +
                ", feed= " + feed +
                ", kszt_h= " + kszt_h() +
                ", mb_kszt= " + mb_kszt()+
                '}';
    }
}
