package com.example.colorchanger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class HelloController {

    @FXML
    private Circle kor;
    @FXML
    private Ellipse ellipszis;
    @FXML
    private Rectangle negyzet;

    private Paint cicrleStroke = Color.rgb(0, 0, 0);
    private Paint ellipseStroke = Color.rgb(0, 0, 0);
    private Paint rectangleStroke = Color.rgb(0, 0, 0);

    private Color generateColor() {
        Random rand = new Random();
        return Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    @FXML
    protected void changeCircleColor() {
        kor.setFill(generateColor());

        cicrleStroke = generateColor();
        kor.setStroke(cicrleStroke);
    }

    @FXML
    protected void changeEllipseColor() {
        ellipszis.setFill(generateColor());

        ellipseStroke = generateColor();
        ellipszis.setStroke(ellipseStroke);
    }

    @FXML
    protected void changeRectangleColor() {
        negyzet.setFill(generateColor());

        rectangleStroke = generateColor();
        negyzet.setStroke(rectangleStroke);
    }


    @FXML
    protected void removeCircleStroke() {
        kor.setStroke(null);
    }

    @FXML
    protected void resetCircleStroke() {
        kor.setStroke(cicrleStroke);
    }


    @FXML
    protected void removeEllipseStroke() {
        ellipszis.setStroke(null);
    }

    @FXML
    protected void resetEllipseStroke() {
        ellipszis.setStroke(ellipseStroke);
    }


    @FXML
    protected void removeRectangleStroke() {
        negyzet.setStroke(null);
    }

    @FXML
    protected void resetRectangleStroke() {
        negyzet.setStroke(rectangleStroke);
    }
}