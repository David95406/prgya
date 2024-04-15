module com.example.javafxwelcome {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxwelcome to javafx.fxml;
    exports com.example.javafxwelcome;
}