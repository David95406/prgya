module com.vizsga.mysqlgyakorlo0413 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.vizsga.mysqlgyakorlo0413 to javafx.fxml;
    exports com.vizsga.mysqlgyakorlo0413;
}