module com.example.esemenyek {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.esemenyek to javafx.fxml;
    exports com.example.esemenyek;
}