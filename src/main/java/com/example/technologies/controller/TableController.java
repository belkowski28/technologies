package com.example.technologies.controller;

import com.example.technologies.model.CsvReader;
import com.example.technologies.model.Punch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableView<Punch> newTable;
    @FXML
    private Pane pane;

    @FXML
    private TableColumn<Punch, Double> table1;

    @FXML
    private TableColumn<Punch, Double> table10;

    @FXML
    private TableColumn<Punch, Double> table11;

    @FXML
    private TableColumn<Punch, Double> table12;

    @FXML
    private TableColumn<Punch, Double> table13;

    @FXML
    private TableColumn<Punch, Double> table14;

    @FXML
    private TableColumn<Punch, Double> table15;

    @FXML
    private TableColumn<Punch, String> table2;

    @FXML
    private TableColumn<Punch, Double> table3;

    @FXML
    private TableColumn<Punch, Double> table4;

    @FXML
    private TableColumn<Punch, Double> table5;

    @FXML
    private TableColumn<Punch, Double> table6;

    @FXML
    private TableColumn<Punch, Double> table7;

    @FXML
    private TableColumn<Punch, Double> table8;

    @FXML
    private TableColumn<Punch, Double> table9;

    private Punch punches;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableCreate();
    }

    public void tableCreate (){

        ObservableList<Punch> listPunch = FXCollections.observableArrayList();

        table1.setText("Średnica\n[mm]");
        table1.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter"));

        table2.setText("Zakres tolerancji\n[mm]");

        table3.setText("min.");
        table3.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter_min"));

        table4.setText("max");
        table4.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter_max"));

        table5.setText("długość\nposuwu\n[mm]");
        table5.setCellValueFactory(new PropertyValueFactory<Punch, Double>("feed"));

        table6.setText("skok\nEPE");
        table6.setCellValueFactory(new PropertyValueFactory<Punch, Double>("quantity_in_the_matrix"));

        table7.setText ("skok\nLAM.");
        table7.setCellValueFactory(new PropertyValueFactory<Punch, Double>("quantity_in_the_matrix_sx"));

        table8.setText("ilość kszt./h.");

        table11.setText("250");
        table11.setCellValueFactory(new PropertyValueFactory<Punch, Double>("kszt_h_sx"));
        table12.setText("300");
        table12.setCellValueFactory(new PropertyValueFactory<Punch, Double>("kszt_h_epe"));
        //table13.setText("320");

        table14.setText("EPE\n1mb=kszt.");
        table14.setCellValueFactory(new PropertyValueFactory<Punch, Double>("mb_kszt_epe"));

        table15.setText("LAM\n1mb=kszt.");
        table15.setCellValueFactory(new PropertyValueFactory<Punch, Double>("mb_kszt_sx"));

        CsvReader csvReader = CsvReader.getInstance();
        for(Punch punch : csvReader.getPunches()) {
            newTable.getItems().add(punch);
            //System.out.println(punch);
        }

        newTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                punches = (Punch)newTable.getSelectionModel().getSelectedItem();
                System.out.println(punches.getDiameter());
            }
        });


    }
}
