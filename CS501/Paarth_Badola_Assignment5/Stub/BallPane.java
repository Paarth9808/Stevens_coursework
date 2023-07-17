import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BallPane extends Pane {
	private Circle circle = new Circle(20, 20, 20);

	// Construct a default ball pane
	public BallPane() {
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		getChildren().add(circle); // Place a ball into this pane
	}

	// Move ball left
	public void left() { 
		circle.setCenterX(circle.getCenterX() > circle.getRadius() ? 
			circle.getCenterX() - 20 : circle.getCenterX());
		circle.setCenterY(circle.getCenterY());
	}

	// Move ball right
	public void right() {
		//TODO: define the direction to move ball towards right
	}

	// Move ball up
	public void up() {
		circle.setCenterY(circle.getCenterY() > circle.getRadius() ? 
			circle.getCenterY() - 20 : circle.getCenterY());
		circle.setCenterX(circle.getCenterX());
	}

	// Move ball down
	public void down() {
		//TODO: define the direction to move ball downwards
	}
}