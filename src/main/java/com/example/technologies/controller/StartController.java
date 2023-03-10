package com.example.technologies.controller;

import com.example.technologies.model.CsvReader;
import com.example.technologies.model.Punch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CsvReader csvReader = new CsvReader();

        for(Punch punch : csvReader.getPunches()){
            System.out.println(punch);
        }
    }
}