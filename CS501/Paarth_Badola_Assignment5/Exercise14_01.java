// Paarth Badola
// 20012789

package com.example.assignment_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Exercise14_01 extends Application{
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setHgap(6);
        pane.setVgap(6);

        try {
            Image img1 = new Image(new FileInputStream("src\\Stub\\Q1\\ca.gif"));
            Image img2 = new Image(new FileInputStream("src\\Stub\\Q1\\uk.gif"));
            Image img3 = new Image(new FileInputStream("src\\Stub\\Q1\\us.gif"));
            Image img4 = new Image(new FileInputStream("src\\Stub\\Q1\\china.gif"));
            //pane.getChildren().addAll(new ImageView(img1), new ImageView(img2), new ImageView(img3), new ImageView(img4));
            pane.add(new ImageView(img1), 0, 0);
            pane.add(new ImageView(img2), 1, 0);
            pane.add(new ImageView(img3), 0, 1);
            pane.add(new ImageView(img4), 1, 1);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }


        Scene scene = new Scene(pane);

        primaryStage.setTitle("Exercise 14_01");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
