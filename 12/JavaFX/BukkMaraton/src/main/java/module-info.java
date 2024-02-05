module com.example.bukkmaraton {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bukkmaraton to javafx.fxml;
    exports com.example.bukkmaraton;
}