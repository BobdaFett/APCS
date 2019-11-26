package unitLoops;

import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 * Takes input from the user and calculates their GPA with the data gathered.
 * 
 * @author Lucas Vas
 */

public class GPACalc extends Application {
	
	public static ArrayList<String> classes;
	public static ArrayList<Double> credits;
	public static ArrayList<Double> grade;
	public static int count;
	
	public void start(Stage s) throws Exception {
		
		classes = new ArrayList<>();
		credits = new ArrayList<>();
		grade = new ArrayList<>();
		
		Button b1 = new Button("Add a class");
		b1.setOnAction(e -> { createClass(); });
		
		Button b2 = new Button("Calculate GPA");
		b2.setOnAction(e -> { calc(); });
		
		Button b3 = new Button("Close window");
		b2.setOnAction(e -> { s.close(); });
		
		GridPane gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		
		gp.setPadding(new Insets(15));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
		
	}
	
	
	public static void main(String[] args) {
		Application.launch();
	}
	
	public void createClass() {
		Stage s = new Stage();
		Button b1 = new Button("Submit");
		b1.setDefaultButton(true);
		Text t = new Text("Select your class\'s information: ");
		ObservableList<Object> classOptions = FXCollections.observableArrayList("Math", "Science", "English", "History/Social Studies", "Civics");
		ObservableList<Object> gradeOptions = FXCollections.observableArrayList("A", "B", "C", "D", "F");
		ObservableList<Object> lengthOptions = FXCollections.observableArrayList("Half", "Full");
		ComboBox classesBox = new ComboBox(classOptions);
		ComboBox gradesBox = new ComboBox(gradeOptions);
		ComboBox lengthBox = new ComboBox(lengthOptions);
		
		b1.setOnAction(e -> {
			try {
				classes.add(classesBox.getSelectionModel().getSelectedItem().toString());
				grade.add((double) gradesBox.getSelectionModel().getSelectedIndex());
				switch(gradesBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) {
				case "half":
					credits.add(0.5);
					break;
				case "full":
					credits.add(1.0);
					break;
				}
				s.close();
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
			}
		});
		
		
		ColumnConstraints cc = new ColumnConstraints();
		GridPane gp = new GridPane();
		gp.getColumnConstraints().add(cc);
		gp.add(t, 0, 0);
		gp.add(classesBox, 0, 1);
		gp.add(gradesBox, 0, 2);
		gp.add(lengthBox, 0, 3);
		gp.add(b1, 1, 1);
		
		gp.setPadding(new Insets(10));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
	}
	
	
	public void calc() {
		for(int i = 1; i < credits.size(); i++) {
			double temp = grade.get(i)/credits.get(i); //grade (total points) divided by credits (total credits possible for that class)
			System.out.println("You have a " + temp + " GPA in your " + classes.get(i) + " class");
		}
		//Eventually make a part here where it calculates your total GPA overall.
	}
	
	public static void errorWindow(String errorType, String message) {
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
}