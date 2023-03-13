package com.example.technologies.controller;

import com.example.technologies.model.CsvReader;
import com.example.technologies.model.Punch;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToIntFunction;

public class StartController implements Initializable {


    @FXML
    private BorderPane borderPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView table;
    private Punch punches;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void speed(ActionEvent event) {
        tableCreate();
    }

    public void tableCreate (){

        anchorPane = new AnchorPane();

        ObservableList <Punch> listPunch = FXCollections.observableArrayList();

        table = new TableView<Punch>();
        table.setMinSize(200,200);
        table.setFixedCellSize(50);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn firstTableColumn = new TableColumn<Punch, String> ("Średnica\n[mm]");
        firstTableColumn.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter"));
        //firstTableColumn.setStyle("-fx-background-color:silver");

        TableColumn diameterMin = new TableColumn<Punch, String> ("min.    ");
        diameterMin.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter_min"));


        TableColumn diameterMax = new TableColumn<Punch, String> ("max     ");
        diameterMax.setCellValueFactory(new PropertyValueFactory<Punch, Double>("diameter_max"));


        TableColumn range_of_tolerance = new TableColumn<Punch, String> ("Zakres tolerancji\n[mm]");

        range_of_tolerance.getColumns().addAll(diameterMin,diameterMax);

        TableColumn feed = new TableColumn<Punch, String> ("długość\nposuwu\n[mm]");
        feed.setCellValueFactory(new PropertyValueFactory<Punch, Double>("feed"));

        TableColumn quantityInTheMatrix = new TableColumn<Punch, String> ("skok\nEPE");
        quantityInTheMatrix.setCellValueFactory(new PropertyValueFactory<Punch, Double>("quantity_in_the_matrix"));


        TableColumn quantityInTheMatrix_sx = new TableColumn<Punch, String> ("skok\nLAM.");
        quantityInTheMatrix_sx.setCellValueFactory(new PropertyValueFactory<Punch, Double>("quantity_in_the_matrix_sx"));

        TableColumn kszt_h_epe = new TableColumn<Punch, String> ("300");
        kszt_h_epe.setCellValueFactory(new PropertyValueFactory<Punch, Double>("kszt_h_epe"));

        TableColumn kszt_h_sx = new TableColumn<Punch, String> ("250");
        kszt_h_sx.setCellValueFactory(new PropertyValueFactory<Punch, Double>("kszt_h_sx"));

        TableColumn kszt_h= new TableColumn<Punch, String> ("ilość kszt./h.");
        kszt_h.getColumns().addAll(kszt_h_sx,kszt_h_epe);

        TableColumn mb_kszt_epe = new TableColumn<Punch, String> ("EPE\n1mb=kszt.");
        mb_kszt_epe.setCellValueFactory(new PropertyValueFactory<Punch, Double>("mb_kszt_epe"));

        TableColumn mb_kszt_sx = new TableColumn<Punch, String> ("LAM\n1mb=kszt.");
        mb_kszt_sx.setCellValueFactory(new PropertyValueFactory<Punch, Double>("mb_kszt_sx"));


        CsvReader csvReader = CsvReader.getInstance();
        for(Punch punch : csvReader.getPunches()) {
            table.getItems().add(punch);
            //System.out.println(punch);
        }

        table.getColumns().addAll(firstTableColumn,range_of_tolerance,feed,quantityInTheMatrix,
                quantityInTheMatrix_sx, kszt_h,mb_kszt_epe,mb_kszt_sx);

        anchorPane.getChildren().add(table);
        AnchorPane.setTopAnchor(table, 10.0);
        AnchorPane.setLeftAnchor(table, 10.0);
        AnchorPane.setRightAnchor(table, 10.0);
        AnchorPane.setBottomAnchor(table, 100.0);
        TextField field = new TextField();
        TextField field1 = new TextField();
        TextField field2 = new TextField();
        Label label = new Label("Średnica");
        Label label1 = new Label("Wydajność EPE:");
        Label label2 = new Label("Wydajność Laminowana:");
        HBox hBox = new HBox(label,field,label1,field1,label2,field2);
        hBox.setPadding(new Insets(40,40,40,40));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        anchorPane.getChildren().add(hBox);
        AnchorPane.setBottomAnchor(hBox, 1.0);

        BorderPane.setAlignment(anchorPane, Pos.CENTER_LEFT);
        borderPane.setCenter(anchorPane);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                punches = (Punch)table.getSelectionModel().getSelectedItem();
                field.setText(String.valueOf(punches.getDiameter()));
                field1.setText(String.valueOf(punches.getKszt_h_epe()));
                field2.setText(String.valueOf(punches.getKszt_h_sx()));
            }
        });

    }
}