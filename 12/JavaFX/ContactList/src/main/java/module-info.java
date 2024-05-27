module com.example.contactlist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contactlist to javafx.fxml;
    exports com.example.contactlist;
}