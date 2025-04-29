module com.example.szerepjatekkarakterekgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.szerepjatekkarakterekgui to javafx.fxml;
    exports com.example.szerepjatekkarakterekgui;
}