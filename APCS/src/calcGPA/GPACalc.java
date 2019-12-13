package calcGPA;

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
	
	public static ArrayList<SchoolClass> accounts;
	
	public static int count;
	
	public void start(Stage s) throws Exception { //initial window method
		
		accounts = new ArrayList<SchoolClass>();
		
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
				
				//creates SchoolClass object and adds it to an ArrayList - should allow you to add multiple of the same name object.
				SchoolClass cl = new SchoolClass(classesBox.getSelectionModel().getSelectedItem().toString(), gradesBox.getSelectionModel().getSelectedItem().toString(), lengthBox.getSelectionModel().getSelectedItem().toString());
				accounts.add(cl);
				
				//another debug idea - create multiple objects and then print all of their names with a foreach loop.
				
				classesBox.valueProperty().set("");
				gradesBox.valueProperty().set("");
				lengthBox.valueProperty().set("");
				
			} catch(Exception f) {
				errorWindow("UNKNOWN ERROR", "That didn't work - try again.");
			}
		});
		
		calc.setOnAction(e -> { 
//			calculate();
			
			for(SchoolClass f : accounts) {
				System.out.println(f.getName());
			}
			
		});
		
		GridPane gp = new GridPane();
		gp.add(t, 0, 0);
		gp.add(classesBox, 0, 1);
		gp.add(gradesBox, 0, 2);
		gp.add(lengthBox, 0, 3);
		
		gp.setPadding(new Insets(10));
		gp.setVgap(10);
		gp.setHgap(10);
		
		gp.add(addClass, 2, 1);
		gp.add(calc, 2, 2);
		
		Scene sc = new Scene(gp);
		
		s.setScene(sc);
		s.show();
		
	}
	
	public double calculate() { //GPA calculation method
		
		double tempGPA = 0.0;
		int numClasses = 0;
		
		for(SchoolClass e : accounts) {
			tempGPA += e.calcGPA();
			numClasses++;
		}
		
		return tempGPA/numClasses;
		
	}
	
	public static void errorWindow(String errorType, String message) { //error window method
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);
		
		error.showAndWait();
	}
	
	public static void main(String[] args) { //lauch method
		Application.launch();
	}
	
}