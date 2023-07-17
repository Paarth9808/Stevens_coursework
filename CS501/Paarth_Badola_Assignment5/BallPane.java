package com.example.assignment_4;
// Paarth Badola
// 20012789

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
    Circle circle;
    BallPane() {
        circle = new Circle(100, 100, 10);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);
    }

    void bLeft(){
        // Conditional statement if true we decrease center pos else we give 0
        circle.setCenterX(circle.getCenterX() - circle.getRadius() > 0 ? circle.getCenterX() - 5 : circle.getCenterX());
    }


    void bRight() {

            circle.setCenterX(circle.getCenterX() + circle.getRadius() < this.getWidth() ? circle.getCenterX() + 5 : circle.getCenterX());
    }

    void bUp() {

            circle.setCenterY(circle.getCenterY() - circle.getRadius() > 0 ? circle.getCenterY() - 5 : circle.getCenterX());
    }

    void bDown() {
            circle.setCenterY(circle.getCenterY() + circle.getRadius() < this.getHeight() ? circle.getCenterY() + 5 : circle.getCenterX());
    }
}
