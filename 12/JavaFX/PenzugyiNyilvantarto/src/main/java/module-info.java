module com.example.penzugyinyilvantarto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.penzugyinyilvantarto to javafx.fxml;
    exports com.example.penzugyinyilvantarto;
}