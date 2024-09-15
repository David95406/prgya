module com.example.pizzeriaalap {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.pizzeriaalap to javafx.fxml;
    exports com.example.pizzeriaalap;
}