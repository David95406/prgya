module com.vizsga.nevsortest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vizsga.nevsortest to javafx.fxml;
    exports com.vizsga.nevsortest;
}