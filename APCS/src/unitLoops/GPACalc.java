package unitLoops;

import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.*;

/**
 * Takes input from the user and calculates their GPA with the data gathered.
 * 
 * @author Lucas Vas
 */

public class GPACalc extends Application {
	
	public static List<String> classes;
	public static List<Double> credits;
	public static List<Double> grade;
	public static int count;
	
	public void start(Stage s) throws Exception {
		
		classes = new ArrayList<>();
		credits = new ArrayList<>();
		grade = new ArrayList<>();
		
		Button b1 = new Button("Add a class");
		b1.setOnAction(e -> {
			createClass();
		});
		
		Button b2 = new Button("Close window");
		b2.setOnAction(e -> {
			s.close();
		});
		
		GridPane gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		
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
		TextArea ta = new TextArea();
		Text t = new Text("Enter a class below: ");
		
		ta.setOnKeyPressed(keyEvent -> {
			if(keyEvent.getCode() == KeyCode.ENTER) {
				//DO STUFFFFFF
			}
		});
		
		b1.setOnAction(e -> {
			try {
				String temp = ta.getText();
				classes.add(temp);
				s.close();
				enterGrade();
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
			}
		});
		
		GridPane gp = new GridPane();
		gp.add(t, 0, 0);
		gp.add(ta, 0, 1);
		gp.add(b1, 1, 1);
		
		gp.setPadding(new Insets(10));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
	}
	
	public void enterGrade() {
		Stage s = new Stage();
		Button b1 = new Button("Submit");
		b1.setDefaultButton(true);
		TextArea ta = new TextArea();
		Text t = new Text("Enter your letter grade below: ");
		
		b1.setOnAction(e -> {
			try {
				switch (ta.getText().toUpperCase()) {
				case "A":
					grade.add(4.0);
					s.close();
					enterLength();
					break;
				case "B":
					grade.add(3.0);
					s.close();
					enterLength();
					break;
				case "C":
					grade.add(2.0);
					s.close();
					enterLength();
					break;
				case "D":
					grade.add(1.0);
					s.close();
					enterLength();
					break;
				case "F": 
					grade.add(0.0);
					s.close();
					enterLength();
					break;
				default:
					if(ta.getText().length() > 1) {
						errorWindow("TOO MANY LETTERS", "Make sure you enter a single letter - more than one will not work.");
					} else {
						errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
					}
					ta.clear();
					break;
				}
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
			}
		});
		
		GridPane gp = new GridPane();
		gp.add(t, 0, 0);
		gp.add(ta, 0, 1);
		gp.add(b1, 1, 1);
		
		gp.setPadding(new Insets(10));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
	}
	
	public void enterLength() {
		Stage s = new Stage();
		Button b1 = new Button("Submit");
		b1.setDefaultButton(true);
		TextArea ta = new TextArea();
		Text t = new Text("Enter the length of the class below: \nEnter \"Half\" or \"Full\"");
		
		b1.setOnAction(e -> {
			try {
				switch(ta.getText().toLowerCase()) {
				case "half":
					credits.add(.5);
					s.close();
					break;
				case "full":
					credits.add(1.0);
					s.close();
					break;
				default:
					errorWindow("INVALID ARGUMENT", "You didn't enter a vaild length.");
					ta.clear();
					break;
				}
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
			}
		});
		
		GridPane gp = new GridPane();
		gp.add(t, 0, 0);
		gp.add(ta, 0, 1);
		gp.add(b1, 1, 1);
		
		gp.setPadding(new Insets(10));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
	}
	
	public void calc() {
		
	}
	
	public static void errorWindow(String errorType, String message) {
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
}


