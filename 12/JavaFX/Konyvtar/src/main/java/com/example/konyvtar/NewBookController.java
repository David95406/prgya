package com.example.konyvtar;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewBookController implements Initializable {
    private final String STOCKVIEW = "stock-view.fxml";
    @FXML
    protected TextField authorInput, titleInput, yearInput;
    @FXML
    protected ComboBox categoryInput;
    @FXML
    protected DatePicker acquisitionDateInput;
    @FXML
    protected Label statusLabel;


    public void switchToKeszlet() throws IOException {
        KonyvtarApplication main = new KonyvtarApplication();
        main.changeScene("stock-view.fxml");
    }

    public void save() {
        try {
            //String author = authorInput.getText();
            //String title = titleInput.getText();
            //int year = Integer.parseInt(yearInput.getText());
            //String category = categoryInput.getId(); //?
            //String acquisitionDate = acquisitionDateInput.toString();
            Book ujKonyv = new Book("Rezso", "123", 210, 0, "123");
            System.out.println(ujKonyv);
            DataManager.addBook(ujKonyv);
            System.out.println(DataManager.getKonyvek());
            KonyvtarApplication.printLabel(statusLabel, "Sikeres mentés!", "green");
        } catch (Exception e) {
            KonyvtarApplication.printLabel(statusLabel, "Hiba!", "red");
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryInput.setItems(FXCollections.observableArrayList("asldjh","spergu"));
    }
}