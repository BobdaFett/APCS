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
		
		lv = new ListView<String>(className);
		
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
		
		MenuBar mb = new MenuBar(m1, m2);
		
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
		
		//create a window to change the information of selected SchoolClass... you're gonna have to make your own custom dialog.
		
		Stage edit = new Stage(); //just because you need to create a new window
		GridPane editGP = new GridPane();
		Button affirm = new Button("Save");
		
		ObservableList<Object> gradeOptions = FXCollections.observableArrayList("A+", "A", "B+", "B", "C+", "C", "D", "F+", "F");
		ObservableList<Object> lengthOptions = FXCollections.observableArrayList("Half Year", "Full Year");
		
		ComboBox<String> nameBox = new ComboBox<String>(); //this should be a text field... i'll fix that later
		ComboBox<Object> gradeBox = new ComboBox<Object>(gradeOptions);
		ComboBox<Object> lengthBox = new ComboBox<Object>(lengthOptions);
		
		affirm.setOnAction(e -> {
			if(!(nameBox.getSelectionModel().isEmpty())) { //true if none, false if there are
				classes.get(index).setName(nameBox.getSelectionModel().toString());
			}
			
			if(!(gradeBox.getSelectionModel().isEmpty())) {
				classes.get(index).setGrade(gradeBox.getSelectionModel().toString());
			}
			
			if(!(lengthBox.getSelectionModel().isEmpty())) {
				classes.get(index).setGrade(lengthBox.getSelectionModel().toString());
			}
			
			edit.close();
		});
		
		editGP.setPadding(new Insets(10));
		editGP.setVgap(5);
		editGP.setHgap(5);
		
		editGP.add(nameBox, 1, 0);
		editGP.add(gradeBox, 1, 1);
		editGP.add(lengthBox, 1, 2);
		
		editGP.add(affirm, 2, 1);
		
		Scene editSC = new Scene(editGP);
		
		edit.setScene(editSC);
		edit.show();
		
	}
	
	public static void delete(int index) {
		
		classes.remove(index);
		className.remove(index); //this should remove from the list
		
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
