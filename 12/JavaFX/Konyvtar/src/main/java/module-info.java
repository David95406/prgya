module com.example.konyvtar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.konyvtar to javafx.fxml;
    exports com.example.konyvtar;
}