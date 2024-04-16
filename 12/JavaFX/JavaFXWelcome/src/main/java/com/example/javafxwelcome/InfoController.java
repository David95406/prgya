package com.example.javafxwelcome;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.util.ArrayList;
public class InfoController {
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Slider progressSlider;
    @FXML
    private Label progressLabel;

    public void progress() {
        double progress = progressSlider.getValue() / 100;
        progressIndicator.setProgress(progress);
        progressLabel.setText(String.format("%.0f", (progress * 100)) + "%");
    }
}
