module com.example.pizzaalap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.pizzaalap to javafx.fxml;
    exports com.example.pizzaalap;
}