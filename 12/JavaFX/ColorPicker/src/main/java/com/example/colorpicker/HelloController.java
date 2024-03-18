package com.example.colorpicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.shape.Ellipse;

public class HelloController {
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Ellipse ellipszis;
    @FXML
    private Slider horizontalSlider, verticalSlider;
    @FXML
    private ImageView patricStar;


    public void changeColor() {
        ellipszis.setFill(colorPicker.getValue());
    }

    @FXML
    protected void changeHorizontal() {
        ellipszis.setRadiusY(horizontalSlider.getValue());

    }

    @FXML
    protected void changeVertical() {
        ellipszis.setRadiusX(verticalSlider.getValue());
    }

    public void showBelai() {
        patricStar.setVisible(!patricStar.isVisible());
    }
}