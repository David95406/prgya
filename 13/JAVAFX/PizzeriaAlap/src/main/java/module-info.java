module com.example.pizzeriaalap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.pizzeriaalap to javafx.fxml;
    exports com.example.pizzeriaalap;
}