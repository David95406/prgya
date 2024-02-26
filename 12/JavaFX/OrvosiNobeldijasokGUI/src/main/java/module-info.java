module com.example.orvosinobeldijasokgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.orvosinobeldijasokgui to javafx.fxml;
    exports com.example.orvosinobeldijasokgui;
}