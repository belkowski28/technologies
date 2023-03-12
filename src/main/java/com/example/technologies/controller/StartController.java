package com.example.technologies.controller;

import com.example.technologies.Application;
import com.example.technologies.model.CsvReader;
import com.example.technologies.model.Punch;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToIntFunction;

public class StartController implements Initializable {


    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void speed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/fxml/table.fxml"));
        ScrollPane hBox = fxmlLoader.load();
        BorderPane.setMargin(hBox,new Insets(5,5,5,5));
        borderPane.setCenter(hBox);
    }
    @FXML
    void table(ActionEvent event) throws IOException {}


}