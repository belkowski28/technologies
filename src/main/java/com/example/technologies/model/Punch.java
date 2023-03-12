package com.example.technologies.model;

public class Punch {

    private double diameter;
    private double diameter_max;
    private double diameter_min;
    private double quantity_in_the_matrix;
    private double quantity_in_the_matrix_sx;
    private double feed;

    private int kszt_h_sx;
    private int kszt_h_epe;
    private double mb_kszt_epe;
    private double mb_kszt_sx;

    public Punch(double diameter, double quantity_in_the_matrix, double feed) {
        this.diameter = diameter;
        this.quantity_in_the_matrix = quantity_in_the_matrix;
        this.quantity_in_the_matrix_sx = quantity_in_the_matrix-2;
        this.feed = feed;
        this.diameter_min = diameter_min();
        this.diameter_max = diameter_max();
        this.kszt_h_epe = (int)kszt_h(300);
        this.kszt_h_sx = (int)kszt_h(250);
        this.mb_kszt_epe = mb_kszt();
        this.mb_kszt_sx = mb_kszt_sx();


    }


    private double kszt_h (int beat){
        return ((beat*this.quantity_in_the_matrix)*60)/1000;
    }

    private double mb_kszt(){

        return Math.round(((this.quantity_in_the_matrix/(this.feed/1000))/1000)*1000.0)/1000.0;
    }
    private double mb_kszt_sx(){
        return Math.round(((this.quantity_in_the_matrix_sx/(this.feed/1000))/1000)*1000.0)/1000.0;
    }
    private double diameter_min(){
        return Math.round((this.diameter - 0.15)*100.0)/100.0;

    }
    private double diameter_max(){
        return Math.round((this.diameter + 0.15)*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Punch{" +
                "diameter= " + diameter +
                ", diameter min=" + diameter_min() +
                ", diameter max=" + diameter_max() +
                ", quantity_in_the_matrix= " + quantity_in_the_matrix +
                ", quantity_in_the_matrix_sx= " + quantity_in_the_matrix_sx +
                ", feed= " + feed +
                ", kszt_h_epe= " + kszt_h(300) +
                ", kszt_h_sx= " + kszt_h(250) +
                ", mb_kszt_epe= " + mb_kszt()+
                ", mb_kszt_sx= " + mb_kszt_sx()+
                '}';
    }

    public double getDiameter() {
        return diameter;
    }

    public double getQuantity_in_the_matrix() {
        return quantity_in_the_matrix;
    }

    public double getFeed() {
        return feed;
    }

    public double getDiameter_max() {
        return diameter_max;
    }

    public double getDiameter_min() {
        return diameter_min;
    }

    public double getQuantity_in_the_matrix_sx() {
        return quantity_in_the_matrix_sx;
    }

    public int getKszt_h_sx() {
        return kszt_h_sx;
    }

    public int getKszt_h_epe() {
        return kszt_h_epe;
    }

    public double getMb_kszt_epe() {
        return mb_kszt_epe;
    }

    public double getMb_kszt_sx() {
        return mb_kszt_sx;
    }
}
