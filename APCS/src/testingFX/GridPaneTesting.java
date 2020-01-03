package testingFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTesting extends Application {

	public void start(Stage s) throws Exception {
		s.setTitle("Testing some GridPanes");

		Button b1 = new Button("Button 1");
		Button b2 = new Button("Button 2");
		Button b3 = new Button("Button 3");
		Button b4 = new Button("This should be bottom right");

		MenuItem mi1 = new MenuItem("Item 1");
		MenuItem mi2 = new MenuItem("Item 2");
		Menu m1 = new Menu("This is a test");
		m1.getItems().add(mi1);
		m1.getItems().add(mi2);

		MenuBar mb = new MenuBar(m1);

		GridPane gp = new GridPane();

		gp.add(mb, 0, 0);
		gp.add(b1, 1, 0);
		gp.add(b2, 1, 1);
		gp.add(b3, 2, 0);
		gp.add(b4, 2, 1);

		gp.setVgap(10);
		gp.setHgap(10);

		// make a VBox and then put the GridPane in it so that i can put the tabs in too

		Scene sc = new Scene(gp, 240, 80);

		s.setScene(sc);
		s.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
