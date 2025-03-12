module com.vizsga.keszletnyilvantarto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vizsga.keszletnyilvantarto to javafx.fxml;
    exports com.vizsga.keszletnyilvantarto;
}