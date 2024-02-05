module com.example.toto0205 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.toto0205 to javafx.fxml;
    exports com.example.toto0205;
}