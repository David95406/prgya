package com.example.lotto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LottoController {
    @FXML
    private Label eredmeny;
    @FXML
    private TextField lottoSzam1;
    @FXML
    private TextField lottoSzam2;
    @FXML
    private TextField lottoSzam3;
    @FXML
    private TextField lottoSzam4;
    @FXML
    private TextField lottoSzam5;

    @FXML
    private TextField userSzam1;
    @FXML
    private TextField userSzam2;
    @FXML
    private TextField userSzam3;
    @FXML
    private TextField userSzam4;
    @FXML
    private TextField userSzam5;

    private final int MIN = 1;
    private final int MAX = 90;
    private int getRandomNumberRegi(ArrayList<Integer> tomb) {
        Random rand = new Random();
        int returnValue;
        do {
            returnValue = rand.nextInt(MAX) + MIN;
        } while (tomb.contains(returnValue));

        return returnValue;
    }

    private int getRandomNumber(ArrayList<Integer> array) {
        Random rand = new Random();
        int returnValue = rand.nextInt(MAX) + MIN;
        if (array.contains(returnValue)) {
            getRandomNumber(array);
        }
        return returnValue;
    }

    @FXML
    private void sorsolas() {
        final int SORSOLT_SZAMOK_DB = 5;
        ArrayList<Integer> userSzamok = new ArrayList<>();
        userSzamok.add(Integer.parseInt(userSzam1.getText()));
        userSzamok.add(Integer.parseInt(userSzam2.getText()));
        userSzamok.add(Integer.parseInt(userSzam3.getText()));
        userSzamok.add(Integer.parseInt(userSzam4.getText()));
        userSzamok.add(Integer.parseInt(userSzam5.getText()));
        /*
        int[] userSzamok = {Integer.parseInt(userSzam1.getText()), Integer.parseInt(userSzam2.getText()),
                Integer.parseInt(userSzam3.getText()), Integer.parseInt(userSzam4.getText()), Integer.parseInt(userSzam5.getText())};
        ArrayList<Integer> sorsoltSzamok = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sorsoltSzamok.add(getRandomNumber());
        }
         */
        ArrayList<Integer> sorsoltSzamok = new ArrayList<>();
        for (int i = 0; i < SORSOLT_SZAMOK_DB; i++) {
            sorsoltSzamok.add(getRandomNumber(sorsoltSzamok));
        }

        lottoSzam1.setText(String.valueOf(sorsoltSzamok.get(0)));
        lottoSzam2.setText(String.valueOf(sorsoltSzamok.get(1)));
        lottoSzam3.setText(String.valueOf(sorsoltSzamok.get(2)));
        lottoSzam4.setText(String.valueOf(sorsoltSzamok.get(3)));
        lottoSzam5.setText(String.valueOf(sorsoltSzamok.get(4)));

        int talalatok = 0;

        for (int i = 0; i < userSzamok.size(); i++) {
            if (sorsoltSzamok.contains(userSzamok.get(i))) {
                talalatok++;
            }
        }

        eredmeny.setText("A találatok száma: " + talalatok);
        
    }
}