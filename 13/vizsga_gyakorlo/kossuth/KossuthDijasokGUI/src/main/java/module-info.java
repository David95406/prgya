module com.vizsga.kossuthdijasokgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vizsga.kossuthdijasokgui to javafx.fxml;
    exports com.vizsga.kossuthdijasokgui;
}