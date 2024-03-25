package com.example.penzugyinyilvantarto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class HelloController {
    @FXML
    TextField kiadasOsszeg, kiadasDatum, kiadasLeiras;
    @FXML
    TextField bevetelOsszeg, bevetelDatum, bevetelLeiras;

    @FXML
    Rectangle kiadasRectangle;
    @FXML
    Rectangle bevetelRectangle;
    @FXML
    Label hibauzenetLabel;

    private ArrayList<Kiadas> osszesKiadas = new ArrayList<>();
    private ArrayList<Bevetel> osszesBevetel = new ArrayList<>();
    private final double MAXRECTANGLEHEIGHT = 250.0;
    private final int OSSZEGOSZTO = 1000;

    private void printLabel(Label l, String value, String color) {
        l.setTextFill(Paint.valueOf(color));
        l.setText(value);
    }

    public void addKiadas() {
        printLabel(hibauzenetLabel, "", "black");

        Kiadas ujKiadas;
        if (!kiadasOsszeg.getText().isEmpty() && !kiadasDatum.getText().isEmpty() &&
                !kiadasLeiras.getText().isEmpty()) {
            ujKiadas = new Kiadas(
                    Integer.parseInt(kiadasOsszeg.getText()),
                    kiadasDatum.getText(),
                    kiadasLeiras.getText()
            );
            osszesKiadas.add(ujKiadas);
        } else if (!kiadasOsszeg.getText().isEmpty() && !kiadasDatum.getText().isEmpty()) {
            ujKiadas = new Kiadas(
                    Integer.parseInt(kiadasOsszeg.getText()),
                    kiadasDatum.getText(),
                    ""
            );
            osszesKiadas.add(ujKiadas);
        } else {
            printLabel(hibauzenetLabel, "Töltse ki a kötelező mezőket!", "red");
            return;
        }

        setKiadasRectangle();

    }

    public void addBevetel() {
        printLabel(hibauzenetLabel, "", "black");

        Bevetel ujBevetel;
        if (!bevetelOsszeg.getText().isEmpty() && !bevetelDatum.getText().isEmpty() &&
                !bevetelLeiras.getText().isEmpty()) {
            ujBevetel = new Bevetel(
                    Integer.parseInt(bevetelOsszeg.getText()),
                    bevetelDatum.getText(),
                    bevetelLeiras.getText()
            );
            osszesBevetel.add(ujBevetel);
        } else if (!bevetelOsszeg.getText().isEmpty() && !bevetelDatum.getText().isEmpty()) {
            ujBevetel = new Bevetel(
                    Integer.parseInt(bevetelOsszeg.getText()),
                    bevetelDatum.getText(),
                    ""
            );
            osszesBevetel.add(ujBevetel);
        } else {
            printLabel(hibauzenetLabel, "Töltse ki a kötelező mezőket!", "red");
            return;
        }

        setBevetelRectangle();
    }

    private void setKiadasRectangle() {
        int osszeg = 0;
        for (Kiadas egyKiadas : osszesKiadas) {
            osszeg += egyKiadas.getOsszeg();
        }

        if (((double) osszeg / OSSZEGOSZTO) < MAXRECTANGLEHEIGHT) {
            kiadasRectangle.setHeight((double) osszeg / OSSZEGOSZTO);
        } else {
            printLabel(hibauzenetLabel, "Megtelt a tablazat!", "red");

        }

    }

    private void setBevetelRectangle() {
        int osszeg = 0;

        for (Bevetel egyBevetel : osszesBevetel) {
            osszeg += egyBevetel.getOsszeg();
        }

        if (((double) osszeg / OSSZEGOSZTO) < MAXRECTANGLEHEIGHT) {
            bevetelRectangle.setHeight((double) osszeg / OSSZEGOSZTO);
        } else {
            printLabel(hibauzenetLabel, "Megtelt a tablazat!", "red");
        }
    }

    private void setRectangles() {
        int kiadasOsszeg = 0;
        int bevetelOsszeg = 0;


        for (Kiadas egyKiadas : osszesKiadas) {
            kiadasOsszeg += egyKiadas.getOsszeg();
        }


        for (Bevetel egyBevetel : osszesBevetel) {
            bevetelOsszeg += egyBevetel.getOsszeg();
        }
        int teljesOsszeg = kiadasOsszeg + bevetelOsszeg;

        double kiadasHeigth = MAXRECTANGLEHEIGHT * (bevetelOsszeg == 0 ? 1 : ((double) (kiadasOsszeg / teljesOsszeg)));
        double bevetelHeight = MAXRECTANGLEHEIGHT * (kiadasOsszeg == 0 ? 1 : ((double) (bevetelOsszeg / teljesOsszeg)));
        kiadasRectangle.setHeight(kiadasHeigth);
        bevetelRectangle.setHeight(bevetelHeight);
        System.out.println(kiadasHeigth);
        System.out.println(bevetelHeight);
        System.out.println((double) kiadasOsszeg / bevetelOsszeg);
    }
}