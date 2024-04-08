package com.example.valasztasok;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class HelloController {
    @FXML
    public Button hozzaadasBtn;
    @FXML
    public TextField searchVNevInput;
    @FXML
    public Button searchVNevBtn;
    @FXML
    public Button searchPartBtn;
    @FXML
    public TextField searchPartInput;
    @FXML
    public Label szavazatokSzamaLabel;
    @FXML
    private Button beolvasasBtn;
    @FXML
    private Label statusLabel;
    @FXML
    public TextField valasztokeruletInput;
    @FXML
    public TextField szavazatokSzamaInput;
    @FXML
    public TextField vezeteknevInput;
    @FXML
    public TextField keresztnevInput;
    @FXML
    public TextField partNevInput;

    private void printLabel(Label l, String value, String color) {
        l.setTextFill(Paint.valueOf(color));
        l.setText(value);
    }

    private void setTextFields(boolean value) {
        valasztokeruletInput.setDisable(!value);
        szavazatokSzamaInput.setDisable(!value);
        vezeteknevInput.setDisable(!value);
        keresztnevInput.setDisable(!value);
        partNevInput.setDisable(!value);
    }

    ArrayList<Szavazat> szavazatok = new ArrayList<>();


    public void beolvasas() {
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("szavazatok.txt", "r");
            String sor = raf.readLine();
            while (sor != null) {
                Szavazat ujSzavazat = new Szavazat(sor.split(" "));
                sor = raf.readLine();
                szavazatok.add(ujSzavazat);
            }
        } catch (Exception e) {
            System.out.println(e);
            printLabel(statusLabel, "Hiba", "red");
            return;
        }
        beolvasasBtn.setVisible(false);
        hozzaadasBtn.setVisible(true);
        setTextFields(true);
        System.out.println(szavazatok);
        searchVNevBtn.setDisable(false);
        searchPartBtn.setDisable(false);
        printLabel(statusLabel, "Sikeres beolvasas!", "green");
    }

    public void hozzaadas() {
        printLabel(statusLabel, "", "black");
        Szavazat ujSzavazat;
        try {
            ujSzavazat = new Szavazat(
                Integer.parseInt(valasztokeruletInput.getText()),
                    Integer.parseInt(szavazatokSzamaInput.getText()),
                    keresztnevInput.getText(),
                    vezeteknevInput.getText(),
                    partNevInput.getText()
            );
        } catch (Exception e) {
            System.out.println(e);
            printLabel(statusLabel, "Hiba", "red");
            return;
        }

        szavazatok.add(ujSzavazat);
        printLabel(statusLabel, "Sikeres hozzaadas!", "green");
        searchVNevBtn.setDisable(false);
        searchPartBtn.setDisable(false);
    }

    public void searchVNev() {
        Szavazat talalat;
        for (Szavazat egySzavazat : szavazatok) {
            if (egySzavazat.getVezeteknev().equals(searchVNevInput.getText())) {
                talalat = egySzavazat;
                valasztokeruletInput.setText(String.valueOf(talalat.getValasztokeruletId()));
                szavazatokSzamaInput.setText(String.valueOf(talalat.getSzavazatokSzama()));
                keresztnevInput.setText(talalat.getKeresztnev());
                vezeteknevInput.setText(talalat.getVezeteknev());
                partNevInput.setText(talalat.getPartnev());
                break;
            }
        }
        if (false) printLabel(statusLabel, "Nincs találat!", "red");
    }

    public void searchPart() {
        String partNev = searchPartInput.getText();
        int szavazatokSzama = 0;
        for (Szavazat egySzavazat : szavazatok) {
            if (egySzavazat.getPartnev().equals(partNev)) {
                szavazatokSzama += egySzavazat.getSzavazatokSzama();
            }
        }
        System.out.println(szavazatokSzama);
        szavazatokSzamaLabel.setText("Szavazatok száma:\n" + szavazatokSzama);

    }
}