package com.example.assignment_4;

// Paarth Badola
// 20012789

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;


public class Grid extends Application{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and place it in the stage
        Pane pane = new Pane();
        primaryStage.setTitle("Grid 3x3");
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);


        Line line1V = new Line(pane.getWidth()/3, 0, pane.getWidth()/3, pane.getHeight());
        line1V.setStrokeWidth(2.5);
        line1V.setStroke(Color.RED);
        pane.getChildren().add(line1V);

        Line line2V = new Line(2*pane.getWidth()/3, 0, 2*pane.getWidth()/3, pane.getHeight());
        line2V.setStrokeWidth(2.5);
        line2V.setStroke(Color.RED);
        pane.getChildren().add(line2V);

        Line line1H = new Line(0, pane.getHeight()/3, pane.getWidth(), pane.getHeight()/3);
        line1H.setStrokeWidth(2.5);
        line1H.setStroke(Color.BLUE);
        pane.getChildren().add(line1H);

        Line line2H = new Line(0, 2*pane.getHeight()/3, pane.getWidth(), 2*pane.getHeight()/3);
        line2H.setStrokeWidth(2.5);
        line2H.setStroke(Color.BLUE);
        pane.getChildren().add(line2H);

        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}





