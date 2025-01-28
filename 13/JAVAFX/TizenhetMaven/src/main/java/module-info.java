module com.example.tizenhetmaven {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tizenhetmaven to javafx.fxml;
    exports com.example.tizenhetmaven;
}