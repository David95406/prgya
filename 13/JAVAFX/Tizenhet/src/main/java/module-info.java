module com.example.tizenhet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tizenhet to javafx.fxml;
    exports com.example.tizenhet;
}