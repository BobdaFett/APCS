package testingFX;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Testing extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Button b1 = new Button("Testing Button");
		b1.setOnAction(event -> {
			System.out.println("this button actually works");
		});
		
		Button b2 = new Button("Testing button #2");
		b2.setOnAction(event -> {
			System.out.println("test 2");
		});
		
		Button b3 = new Button("Click to Fullscreen");
		b3.setOnAction(event -> {
			stage.setFullScreen(true);
			System.out.println("Yeah that worked too");
		});
		
		HBox hb = new HBox(b1, b2);
		
		HBox hb2 = new HBox(b3);
		
		VBox vb = new VBox(hb, hb2);
		
		Scene sc = new Scene(vb);
		stage.setScene(sc);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}
