module com.example.javafx0415 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx0415 to javafx.fxml;
    exports com.example.javafx0415;
}