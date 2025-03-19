module com.example.konyvelfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.konyvelfxml to javafx.fxml;
    exports com.example.konyvelfxml;
}