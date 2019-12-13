package calcGPA;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListViewCalc extends Application {
	
	public static ObservableList<SchoolClass> classes;
	public static ObservableList<String> className;
	public ListView<String> lv;
	
	public void start(Stage s) throws Exception {
		
		classes = FXCollections.observableArrayList();
		className = FXCollections.observableArrayList();
		
		lv = new ListView<String>(className); //want this to display the object name, through the getName() method... but don't see a way to make that happen.
		
		MenuItem file1 = new MenuItem("Create Class");
		file1.setOnAction(e -> {
			create();
		});
		MenuItem file2 = new MenuItem("Exit");
		file2.setOnAction(e -> {
			s.close();
		});
		
		MenuItem edit1 = new MenuItem("Edit Info...");
		edit1.setOnAction(e -> {
			edit(lv.getSelectionModel().getSelectedIndex());
		});
		MenuItem edit2 = new MenuItem("Delete Class");
		edit2.setOnAction(e -> {
			delete(lv.getSelectionModel().getSelectedIndex());
		});
		
		Menu m1 = new Menu("File");
		m1.getItems().addAll(file1, file2);
		Menu m2 = new Menu("Edit");
		m2.getItems().addAll(edit1, edit2);
		
		MenuBar mb = new MenuBar(m1, m2); //create menus beforehand - easy scope
		
		GridPane gp = new GridPane();
		gp.add(mb, 0, 0);
		gp.add(lv, 0, 1);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
	}
	
	public static void create() {
		
		TextInputDialog create = new TextInputDialog();
		create.setTitle("Create Class");
		create.setHeaderText(null);
		create.setContentText("Enter the class name:");
		
		Optional<String> name = create.showAndWait();
		name.ifPresent(e -> {
			SchoolClass cl = new SchoolClass(name.get());
			className.add(cl.getName());
			classes.add(cl);
		});
		
	}
	
	public static void edit(int index) {
		
		//create a window to change the information of selected SchoolClass
		
	}
	
	public static void delete(int index) {
		
		//remove class
		
	}
	
	public static void errorWindow(String errorType, String message) { //error window method
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
