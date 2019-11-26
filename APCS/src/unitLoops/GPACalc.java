package unitLoops;

import java.text.DecimalFormat;
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
	public static ArrayList<Double> gpa;
	public static int count;
	
	public void start(Stage s) throws Exception {
		
		//initialize the ArrayLists
		classes = new ArrayList<>();
		credits = new ArrayList<>();
		grade = new ArrayList<>();
		gpa = new ArrayList<>();
		
		Button b1 = new Button("Add a class");
		b1.setOnAction(e -> { 
			createClass(); 
		});
		
		Button b2 = new Button("Calculate GPA");
		b2.setOnAction(e -> { 
			calculate(); 
		});
		
		Button b3 = new Button("Close window");
		b3.setOnAction(e -> { 
			s.close();
		});
		
		GridPane gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		
		gp.setPadding(new Insets(15));
		gp.setVgap(10);
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		//set scene on stage and then show window
		s.setScene(sc);
		s.show();
		
	}
	
	
	public static void main(String[] args) {
		Application.launch();
	}
	
	public void createClass() {
		Stage s = new Stage();
		
		//create button, and set so that when you hit enter is clicks it.
		Button b1 = new Button("Submit");
		b1.setDefaultButton(true);
		
		//make a text above the options.
		Text t = new Text("Select your class\'s information: ");
		
		//options for the ComboBoxes
		ObservableList<Object> classOptions = FXCollections.observableArrayList("Math", "Science", "English", "History/Social Studies", "Civics");
		ObservableList<Object> gradeOptions = FXCollections.observableArrayList("A", "B", "C", "D", "F");
		ObservableList<Object> lengthOptions = FXCollections.observableArrayList("Half", "Full");
		
		//create the ComboBoxes
		ComboBox<Object> classesBox = new ComboBox<Object>(classOptions);
		ComboBox<Object> gradesBox = new ComboBox<Object>(gradeOptions);
		ComboBox<Object> lengthBox = new ComboBox<Object>(lengthOptions);
		
		b1.setOnAction(e -> {
			try {
				classes.add(classesBox.getSelectionModel().getSelectedItem().toString()); //get the class name from the corresponding ComboBox
				System.out.println("Class: " + classesBox.getSelectionModel().getSelectedItem().toString());
				
				switch(gradesBox.getSelectionModel().getSelectedItem().toString()) { //get the grade selected from the corresponding ComboBox
				case "A":
					grade.add(4.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "B": 
					grade.add(3.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "C":
					grade.add(2.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "D":
					grade.add(1.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "F":
					grade.add(0.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				}
				
				switch(lengthBox.getSelectionModel().getSelectedItem().toString().toLowerCase()) { //get the length of the class from the corresponding ComboBox
				case "half":
					credits.add(2.0);
					System.out.println("Length: " + lengthBox.getSelectionModel().getSelectedItem().toString() + "\n");
					break;
				case "full":
					credits.add(1.0);
					System.out.println("Length: " + lengthBox.getSelectionModel().getSelectedItem().toString() + "\n");
					break;
				}
				
				s.close(); //close window
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again."); //if there's an error do not allow the user to do anything until they acknowledge it
			}
		});
		
		GridPane gp = new GridPane(); //create and add everything to a grid layout
		gp.add(t, 0, 0);
		gp.add(classesBox, 0, 1);
		gp.add(gradesBox, 0, 2);
		gp.add(lengthBox, 0, 3);
		gp.add(b1, 1, 1);
		
		gp.setPadding(new Insets(10)); //set spacing from sides
		gp.setVgap(10); //set spacing between each grid area
		gp.setHgap(10);
		
		Scene sc = new Scene(gp);
		
		//set scene on stage and then show window
		s.setScene(sc);
		s.show();
	}
	
	
	public void calculate() {
		for(int i = 0; i < credits.size(); i++) {
			gpa.add(grade.get(i)/credits.get(i)); //grade (total points) divided by credits (total credits possible for that class)
			
			/*
			 * This will only give the GPA for each individual class, and only in the console for now.
			 * Uses multiple ArrayLists to take the same index for the class, grade, and length, and then associate the GPA with each.
			 */
			
			System.out.println("You have a " + gpa.get(i) + " GPA in your " + classes.get(i) + " class"); //will print the specific gpa and class it's associated with.
		}
		System.out.println();
		double sumGPA = 0;
		for(int i = 0; i < gpa.size(); i++) {
			sumGPA += gpa.get(i);	//temp variable that stores all GPA's added together
		}
		
		//returns your average GPA in all of your classes (all GPA's / number of GPA's)
		double overall = sumGPA/gpa.size();
		DecimalFormat df = new DecimalFormat("#.0"); //allows you to set the number of decimals
		System.out.println("You have a " + df.format(overall) + " GPA on average in your classes.");
		
		gpa.clear();
	}
	
	public static void errorWindow(String errorType, String message) { //error window method
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
}