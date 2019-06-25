package assignment_3;

//imported packages for program functionality
import javafx.application.Application;
import javafx.stage.*;
import java.util.Random;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;

public class Circles extends Application {
	
	//main method used to launch program
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Circle c; //circle object
		int largestRadius = 0; //variable which initializes the largest radius
		int radius = 0; //variables for circle values
		int x = 0;
		int y = 0;
		int lx = 0;
		int ly = 0;
		Random gen = new Random();//uses Random class
		Group root = new Group();//used for grouping nodes
		
		//for loop which iterates ten times creating ten circles
		for(int i = 0; i < 10; i++) {
			//randomly generates coordinates for each circle object
			x = gen.nextInt(400) + 1;
			y = gen.nextInt(400) + 1;
			//randomly generates radius for circle
			radius = gen.nextInt(50) + 1;
			//creates circle object using randomly generated values
			c = new Circle(x,y, radius);
			//sets the largest radius to current iteration of radius if larger
			if (radius > largestRadius) {
				largestRadius = radius;
				lx = x;
				ly = y;
			}
			//sets outline color of circles
			c.setStroke(Color.WHITE);
			root.getChildren().add(c);
		}
		//circle object for largest circle
		Circle cl = new Circle(lx,ly,largestRadius);//passes in largest values
		cl.setStroke(Color.WHITE);
		cl.setOpacity(.3);//sets opacity to 30%
		cl.setFill(Color.RED);//fills color of circle to red
		root.getChildren().add(cl);//adds to group
		
		//sets the scene by passing in the group and setting size
		Scene s = new Scene(root, 400, 400, Color.BLACK);
		//creates stage
		primaryStage.setScene(s);
		primaryStage.show();
	}

}
