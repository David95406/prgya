module com.vizsga.vizsgaproba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vizsga.vizsgaproba to javafx.fxml;
    exports com.vizsga.vizsgaproba;
}