package com.example.javafx0415;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class HelloController {
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