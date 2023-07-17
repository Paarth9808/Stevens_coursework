package com.example.assignment_4;

// Paarth Badola
// 20012789

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Random;

public class DrawTwoCircle extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage){

        // Create a pane
        Pane pane = new Pane();
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        Random r = new Random();
        Circle circle1 = new Circle();
        circle1.setCenterX(Math.random()*scene.getWidth());
        circle1.setCenterY(Math.random()*scene.getHeight());
        circle1.setRadius(15);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.WHITE);

        Circle circle2 = new Circle();
        circle2.setCenterX(Math.random()*scene.getHeight());
        circle2.setCenterY(Math.random()*scene.getHeight());
        circle2.setRadius(15);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.WHITE);

        //double startX = Math.hypot(circle1.getCenterX(), circle1.getCenterY());

        Line line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        // Add nodes to pane
        pane.getChildren().addAll(line, circle1, circle2);
        pane.getChildren().addAll( new Text(circle1.getCenterX(), circle1.getCenterY(), "1"), new Text(circle2.getCenterX(), circle2.getCenterY(), "2"));


        primaryStage.setTitle("Draw Two Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}
