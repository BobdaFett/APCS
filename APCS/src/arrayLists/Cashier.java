package arrayLists;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cashier extends Application {

	public static TableView<Item> tv;
	public static ObservableList<Item> items;

	/**
	 * Creates the base window for the application.
	 * 
	 * @param s
	 * @throws Exception
	 */
	public void start(Stage s) throws Exception {

		tv = new TableView<Item>(items);
		TableColumn<Item, String> t1 = new TableColumn<Item, String>();
		t1.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));

		TableColumn<Item, String> t2 = new TableColumn<Item, String>();
		t2.setCellValueFactory(new PropertyValueFactory<Item, String>("age"));

		TableColumn<Item, String> t3 = new TableColumn<Item, String>();
		t3.setCellValueFactory(new PropertyValueFactory<Item, String>("type"));

		tv.getColumns().addAll(t1, t2, t3);

		Button temp = new Button("click this thing");
		temp.setOnAction(e -> {
			edit(new Item());
		});

		GridPane gp = new GridPane();
		gp.add(tv, 0, 1);
		gp.add(temp, 0, 2);

		Scene sc = new Scene(gp);

		s.setScene(sc);
		s.show();

	}

	/**
	 * Allows the user to edit the item they're currently selecting.
	 * 
	 * @param item
	 */
	public static void edit(Item item) {

		Dialog<Results> edit = new Dialog<Results>(); // create a new dialog

		DialogPane dp = edit.getDialogPane();
		dp.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		TextField nEdit = new TextField(item.getName());
		TextField tEdit = new TextField(item.getType());
		Spinner<Integer> pEdit = new Spinner<Integer>();
		Button adv = new Button("Advanced...");

		dp.setContent(new VBox(8, nEdit, tEdit, pEdit, adv)); // set the content of the DialogPane

		Platform.runLater(nEdit::requestFocus); // means that the TextField will ask for the focus of the user after the platform is generated

		edit.setResultConverter((ButtonType button) -> { // will return all of the entered information when you hit the OK button (ButtonType.OK)
			if (button == ButtonType.OK) {
				return new Results(nEdit.getText(), tEdit.getText()); // it's all inside of an object for ease of access
			}
			return null;
		});

		Optional<Results> result = edit.showAndWait(); // after button is pressed it will close the window
		result.ifPresent((Results debug) -> {
			System.out.println(debug.text + "" + debug.type); // this is all just for debugging
		});

	}

	/**
	 * Start the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * The results class for ease of access.
	 * 
	 * @author lvas
	 *
	 */
	private static class Results {

		String text;
		String type;

		public Results(String name, String type) {
			this.text = name;
			this.type = type;
		}
	}

}
