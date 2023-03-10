module com.example.technologies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.technologies to javafx.fxml;
    exports com.example.technologies;
    exports com.example.technologies.controller;
    opens com.example.technologies.controller to javafx.fxml;
}