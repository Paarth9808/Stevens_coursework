package com.example.assignment_4;

// Paarth Badola
// 20012789

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class CheckerBoard extends Application{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create rectangles
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 400, 400);

        // black board (red squares added later)
        Rectangle rect1 = new Rectangle(0, 0, scene.getWidth(), scene.getHeight());
        rect1.setFill(Color.BLACK);
        pane.getChildren().add(rect1);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i+j) % 2 == 0){

                    int x = i * (int)(scene.getWidth()/8);
                    int y = j * (int)(scene.getHeight()/8);

                    Rectangle rect2 = new Rectangle(x, y, (int)scene.getWidth()/8 , (int)scene.getHeight()/8);
                    rect2.setFill(Color.WHITE);
                    pane.getChildren().add(rect2);
                }
            }
        }

        primaryStage.setTitle("Checkerboard");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
