package com.example.assignment_4;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;


public class Exercise15_02 extends Application {
    public void start(Stage primaryStage) {
        PendulumPane pendulum = new PendulumPane();

        pendulum.setMinWidth(200);
        pendulum.setMinHeight(200);
        pendulum.setMaxWidth(200);
        pendulum.setMaxHeight(200);


        pendulum.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pendulum.stop();
            }
        });

        pendulum.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pendulum.resume();
            }
        });


        Scene scene = new Scene(pendulum);
        primaryStage.setTitle("Exercise15_02");
        primaryStage.setScene(scene);
        primaryStage.show();

        pendulum.requestFocus();


    }
}

class PendulumPane extends Pane {

    Circle pendulumBall;
    Arc pendulumLine;
    PathTransition pendulumTrace;

    PendulumPane() {

        //Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length);
        pendulumLine = new Arc(100, 0, 140, 140, 240, 60);
        pendulumLine.setFill(Color.TRANSPARENT);
        pendulumLine.setStroke(Color.BLACK);

        pendulumBall = new Circle(10);
        pendulumBall.setFill(Color.ORANGE);


        getChildren().addAll(pendulumLine, pendulumBall);

        pendulumTrace = new PathTransition();
        pendulumTrace.setDuration(Duration.millis(2000));
        pendulumTrace.setPath(pendulumLine);
        pendulumTrace.setNode(pendulumBall);
        pendulumTrace.setAutoReverse(true);
        pendulumTrace.setCycleCount(Timeline.INDEFINITE);
        pendulumTrace.play();

    }

    void resume() {
        pendulumTrace.play();
    }

    void stop() {
        pendulumTrace.pause();
    }

}
