module com.vizsga.databaseconngyak {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.vizsga.databaseconngyak to javafx.fxml;
    exports com.vizsga.databaseconngyak;
}