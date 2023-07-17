package com.example.assignment_4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise15_01 extends Application{
    public void start(Stage primaryStage) {
        BallPane ball1 = new BallPane();
        // creating buttons for our actions
        HBox hbox = new HBox(5);
        Button buttonLeft = new Button("Left");
        Button buttonRight = new Button("Right");
        Button buttonUp = new Button("Up");
        Button buttonDown = new Button("Down");
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(buttonLeft, buttonRight, buttonUp, buttonDown);

        // Conditional statement if true we decrease center pos else we give 0
        buttonLeft.setOnAction(e ->{
            ball1.bLeft();
        });

        buttonRight.setOnAction(e ->{
            ball1.bRight();
        });

        buttonUp.setOnAction(e ->{
            ball1.bUp();
        });

        buttonDown.setOnAction(e ->{
            ball1.bDown();
        });

        // Border pane to put everything
        BorderPane borderPane = new BorderPane();
        // adding circle to borer pane
        borderPane.setCenter(ball1);
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.TOP_CENTER);

        Scene scene = new Scene(borderPane, 200, 200);

        primaryStage.setTitle("Exercise 15_01");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
