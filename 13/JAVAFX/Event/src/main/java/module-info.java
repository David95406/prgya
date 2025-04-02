module com.example.event {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.event to javafx.fxml;
    exports com.example.event;
}