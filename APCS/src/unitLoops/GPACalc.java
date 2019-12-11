package unitLoops;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	
	public static ArrayList<String> classes;
	public static ArrayList<Double> credits;
	public static ArrayList<Double> grade;
	public static ArrayList<Double> gpa;
	public static int count;
	
	@SuppressWarnings("exports")
	public void start(Stage s) throws Exception { //initial window method
		
		//initialize the ArrayLists
		classes = new ArrayList<>();
		credits = new ArrayList<>();
		grade = new ArrayList<>();
		gpa = new ArrayList<>();
		
		Button addClass = new Button("Add class");
		
		Button calc = new Button("Calculate GPA");
		
		//make a text above the options.
		Text t = new Text("Select your class\'s information: ");
		
		//options for the ComboBoxes
		ObservableList<Object> classOptions = FXCollections.observableArrayList("Math", "Science", "English", "History/Social Studies", "Civics", "Other"); //all possible classes so far.... might import the school catalog and see what i can do with that
		ObservableList<Object> gradeOptions = FXCollections.observableArrayList("A+", "A", "B+", "B", "C+", "C", "D", "F+", "F"); //added the more complex grades (the "+" grades)
		ObservableList<Object> lengthOptions = FXCollections.observableArrayList("Half Year", "Full Year"); //possible lengths of the classes
		
		//create the ComboBoxes
		ComboBox<Object> classesBox = new ComboBox<Object>(classOptions);
		classesBox.getSelectionModel().selectedItemProperty().addListener(e -> { //called any time the user selects something in this box
			switch(classesBox.getSelectionModel().getSelectedItem().toString()) {
			case "Other": //create an area for the user to enter their custom class
				System.out.println("Other");
				break;
			}
		});
		
		ComboBox<Object> gradesBox = new ComboBox<Object>(gradeOptions);
		ComboBox<Object> lengthBox = new ComboBox<Object>(lengthOptions);
		
		addClass.setOnAction(e -> {
			try {
				classes.add(classesBox.getSelectionModel().getSelectedItem().toString()); //get the class name from the corresponding ComboBox
				System.out.println("Class: " + classesBox.getSelectionModel().getSelectedItem().toString());
				
				switch(gradesBox.getSelectionModel().getSelectedItem().toString()) { //get the grade selected from the corresponding ComboBox
				case "A+":
					grade.add(4.0); //needed to specify a value for division later
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString()); //really for debugging, but useful until I find a way to make a place that updates for this
					break;
				case "A":
					grade.add(3.5);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "B+":
					grade.add(3.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "B":
					grade.add(2.5);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "C+":
					grade.add(2.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "C":
					grade.add(1.5);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "D": 
					grade.add(1.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "F+":
					grade.add(0.5);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				case "F":
					grade.add(0.0);
					System.out.println("Grade: " + gradesBox.getSelectionModel().getSelectedItem().toString());
					break;
				}
				
				switch(lengthBox.getSelectionModel().getSelectedItem().toString()) { //get the length of the class from the corresponding ComboBox
				case "Half Year":
					credits.add(2.0); //this is because you're dividing - dividing by a decimal makes a larger number.
					System.out.println("Length: " + lengthBox.getSelectionModel().getSelectedItem().toString() + "\n");
					break;
				case "Full Year":
					credits.add(1.0);
					System.out.println("Length: " + lengthBox.getSelectionModel().getSelectedItem().toString() + "\n");
					break;
				}
				
				classesBox.valueProperty().set("");
				gradesBox.valueProperty().set("");
				lengthBox.valueProperty().set("");
				
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again."); //if there's an error do not allow the user to do anything until they acknowledge it
			}
		});
		
		calc.setOnAction(e -> { 
			calculate(); 
		});
		
		GridPane gp = new GridPane(); //create and add everything to a grid layout
		gp.add(t, 0, 0);
		gp.add(classesBox, 0, 1);
		gp.add(gradesBox, 0, 2);
		gp.add(lengthBox, 0, 3);
		
		gp.setPadding(new Insets(10)); //set spacing from sides
		gp.setVgap(10); //set spacing between each grid area
		gp.setHgap(10);
		
		gp.add(addClass, 2, 1);
		gp.add(calc, 2, 2);
		
		Scene sc = new Scene(gp);
		
		//set scene on stage and then show window
		s.setScene(sc);
		s.show();
		
	}
	
	public static void main(String[] args) { //lauch method
		Application.launch();
	}
	
	public void calculate() { //GPA calculation method
		for(int i = 0; i < credits.size(); i++) {
			gpa.add(grade.get(i)/credits.get(i)); //grade (total points) divided by credits (total credits possible for that class)
			
			/*
			 * This will give the GPA for each individual class and the overall GPA, but still only in the console for now.
			 * Uses multiple ArrayLists to take the same index for the class, grade, and length, and then associate the GPA with each.
			 */
			
			System.out.println("You have a " + gpa.get(i) + " GPA in your " + classes.get(i) + " class."); //will print the specific gpa and class it's associated with. (Math with a 3.5 GPA)
		}
		System.out.println();
		double sumGPA = 0;
		for(int i = 0; i < gpa.size(); i++) {
			sumGPA += gpa.get(i); //temp variable that stores the sum of all GPA's
		}
		
		//returns your GPA over all your classes (all GPA's / number of GPA's)
		double overall = sumGPA/gpa.size();
		DecimalFormat df = new DecimalFormat("#.000"); //allows you to set the number of decimals
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