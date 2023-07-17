// Paarth Badola
// 20012789
package com.example.assignment_4;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class BarChart extends Application{

    public void start(Stage primaryStage) throws Exception{
        double height1 = 500;
        double height2 = 500;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter percentage for project: ");
        double val1 = sc.nextDouble();
        System.out.println("Enter percentage for quiz: ");
        double val2 = sc.nextDouble();
        System.out.println("Enter percentage for midterm: ");
        double val3 = sc.nextDouble();
        System.out.println("Enter percentage for finals: ");
        double val4 = sc.nextDouble();

        double sum = (val1 + val2 + val3 + val4);

        if (sum != 100){
            System.out.println("Total percentage not equal to 100");
            System.exit(0);
        }

        Text t1 = new Text(10, height2-height1*(val1/100), "Project--" + val1);
        Rectangle project = new Rectangle(10, height2-height1*(val1/100), 100, height1*(val1/100));
        project.setFill(Color.RED);

        Text t2 = new Text(130, height2-height1*(val2/100), "Quiz--" + val2);
        Rectangle quiz = new Rectangle(130, height2-height1*(val2/100), 100, height1*(val2/100));
        quiz.setFill(Color.BLUE);

        Text t3 = new Text(250, height2-height1*(val3/100), "Midterm--" + val3);
        Rectangle midterm = new Rectangle(250, height2-height1*(val3/100), 100, height1*(val3/100));
        midterm.setFill(Color.GREEN);

        Text t4 = new Text(380, height2-height1*(val4/100), "Final--" + val4);
        Rectangle finals = new Rectangle(380, height2-height1*(val4/100), 100, height1*(val4/100));
        finals.setFill(Color.ORANGE);

        Group group = new Group();
        group.getChildren().addAll(t1, project, t2, quiz, t3, midterm, t4, finals);

        Scene scene = new Scene(new BorderPane(group), 500, height2);
        primaryStage.setTitle("Bar Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
