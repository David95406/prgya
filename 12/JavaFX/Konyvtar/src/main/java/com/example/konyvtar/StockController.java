package com.example.konyvtar;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StockController {
    @FXML
    protected TableView booksTable;
    @FXML
    protected TableColumn<Book, String> szIrodalomColumn, scifiColumn, nyelvkonyvColumn, tudomanyColumn;

    @FXML
    public void initialize() {
        /*

        szIrodalomColumn.setCellValueFactory(new PropertyValueFactory<>("szépirodalom"));
        scifiColumn.setCellValueFactory(new PropertyValueFactory<>("scifi"));
        nyelvkonyvColumn.setCellValueFactory(new PropertyValueFactory<>("nyelvkönyv"));
        tudomanyColumn.setCellValueFactory(new PropertyValueFactory<>("tudomány"));

        ObservableList<Book> esemenylistaOL = FXCollections.observableArrayList(DataManager.getKonyvek());
        booksTable.setItems(esemenylistaOL);

         */


    }


    public void back() throws IOException {
        KonyvtarApplication.back();
    }
}
