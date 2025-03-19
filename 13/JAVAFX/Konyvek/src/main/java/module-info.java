module com.example.konyvek {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.konyvek to javafx.fxml;
    exports com.example.konyvek;
}