package unitLoops;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RockPaperScissors extends Application {

	public static int userInput = 0;
	
	private static String rock = "https://images.vexels.com/media/users/3/145826/isolated/lists/37a6335f8116ec5d233efd8019e2b2c4-round-rock.png";
	private static String paper = "https://b3h2.scene7.com/is/image/BedBathandBeyond/7155873258644m?$imagePLP$&wid=256&hei=256";
	private static String scissors = "https://cdn10.bigcommerce.com/s-t4yqg98af9/products/571063/images/5493812/api20w1ov__58768.1549431795.256.256.jpg?c=2";
	
	public void start(Stage s) throws Exception {
		
		Image rockImage = new Image(rock);
		Image paperImage = new Image(paper);
		Image scissorsImage = new Image(scissors);
		
		Button rockButton = new Button();
		rockButton.setGraphic(new ImageView(rockImage));
		rockButton.setOnAction(e -> {
			userInput = 1; //1 beats 3
			System.out.println(userInput);
		});
		
		Button paperButton = new Button();
		paperButton.setGraphic(new ImageView(paperImage));
		paperButton.setOnAction(e -> {
			userInput = 2; //2 beats 1
			System.out.println(userInput);
		});
		
		Button scissorsButton = new Button();
		scissorsButton.setGraphic(new ImageView(scissorsImage));
		scissorsButton.setOnAction(e -> {
			userInput = 3; //3 beats 2
			System.out.println(userInput);
		});
		
		ImageView computer = new ImageView(paperImage);
		ImageView user = new ImageView(rockImage);
		
		Text t = new Text("VS");
		
		ColumnConstraints cc = new ColumnConstraints();
		
		GridPane gp = new GridPane();
		
		cc.setPercentWidth(50);
		
		gp.add(rockButton, 0, 0);
		gp.add(paperButton, 1, 0);
		gp.add(scissorsButton, 2, 0);
		gp.add(computer, 0, 1);
		gp.getColumnConstraints().add(cc);
		gp.add(user, 2, 1);
		gp.setPadding(new Insets(10));
		
		Scene sc = new Scene(gp);
		s.setScene(sc);
		s.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();
	}

}
