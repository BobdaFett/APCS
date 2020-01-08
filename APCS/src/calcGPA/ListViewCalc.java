package calcGPA;

import java.util.Optional;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ListViewCalc extends Application {

	public static ObservableList<SchoolClass> classes;
	public int index;

	public static TableView<SchoolClass> lv;

	public static ObservableList<Object> gradeOptions;
	public static ObservableList<Object> lengthOptions;

	/**
	 * Create the window.
	 */
	@SuppressWarnings("unchecked")
	public void start(Stage s) throws Exception {

		classes = FXCollections.observableArrayList();
		gradeOptions = FXCollections.observableArrayList("A+", "A", "B+", "B", "C+", "C", "D", "F+", "F");
		lengthOptions = FXCollections.observableArrayList("Half Year", "Full Year");

		lv = new TableView<SchoolClass>(classes);
		lv.prefWidthProperty().bind(s.widthProperty());
		lv.prefHeightProperty().bind(s.heightProperty());
		lv.setPlaceholder(new Label("Click File > Create to make a new Class"));

		TableColumn<SchoolClass, String> NColumn = new TableColumn<>("Class");
		NColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<SchoolClass, String> GColumn = new TableColumn<>("Grade");
		GColumn.setCellValueFactory(new PropertyValueFactory<>("gradeVerbose"));

		TableColumn<SchoolClass, String> LColumn = new TableColumn<>("Length");
		LColumn.setCellValueFactory(new PropertyValueFactory<>("lengthVerbose"));

		lv.getColumns().addAll(NColumn, GColumn, LColumn);
		lv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		lv.setOnKeyPressed(key -> {
			switch (key.getCode()) {
			case DELETE:
				if (index < 0) {
					warningWindow("Nothing Selected", "Please select a class to continue.");
				} else {
					delete(index);
				}
				break;
			default:
				break;
			}
		});

		lv.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				index = lv.getSelectionModel().getSelectedIndex();
			}
			if (e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 2) {
				edit(index);
			}
		});

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
			if (index < 0) {
				warningWindow("Nothing Selected", "Please select a class to continue.");
			} else {
				edit(index);
			}
		});
		MenuItem edit2 = new MenuItem("Delete Class");
		edit2.setOnAction(e -> {
			if (index < 0) {
				warningWindow("Nothing Selected", "Please select a class to continue.");
			} else {
				delete(index);
			}
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

		s.setMaximized(true);

		s.setScene(sc);
		s.show();
	}

	/**
	 * Creates a window that allows the user to make a class and display it on the
	 * TableView.
	 */
	public static void create1() {

		TextInputDialog create = new TextInputDialog();
		create.setTitle("Create Class");
		create.setHeaderText(null);
		create.setContentText("Enter the class name:");

		Optional<String> name = create.showAndWait();
		name.ifPresent(e -> {
			SchoolClass cl = new SchoolClass(name.get());
			classes.add(cl);
		});

		update();

	}

	/**
	 * Creates a window allowing the user to create a class with optional
	 * components.
	 */
	public static void create() {

		Stage create = new Stage();
		GridPane gCreate = new GridPane();
		Button affirm = new Button("Create");

		Text tName = new Text("Enter a name: ");
		Text tGrade = new Text("Select a grade: ");
		Text tLength = new Text("Select a length: ");

		TextField iName = new TextField();
		ComboBox<Object> iGrade = new ComboBox<Object>(gradeOptions);
		ComboBox<Object> iLength = new ComboBox<Object>(lengthOptions);

		gCreate.setPadding(new Insets(10));
		gCreate.setVgap(5);
		gCreate.setHgap(5);

		gCreate.add(tName, 0, 0);
		gCreate.add(tGrade, 0, 1);
		gCreate.add(tLength, 0, 2);

		gCreate.add(iName, 1, 0);
		gCreate.add(iGrade, 1, 1);
		gCreate.add(iLength, 1, 2);
		gCreate.add(affirm, 2, 2);

		affirm.setOnAction(e -> {

			if (iName.getText().toString() == "") {
				errorWindow("NO NAME", "You can't create a class without a name.");
				create();
			} else {
				SchoolClass c = new SchoolClass(iName.getText()); // need to change this - it's creating classes without names.
				if (!iGrade.getSelectionModel().isEmpty()) {
					c.setGrade(iGrade.getSelectionModel().getSelectedItem().toString());
				}

				if (!(iLength.getSelectionModel().isEmpty())) {
					c.setLength(iLength.getSelectionModel().getSelectedItem().toString());
				}
				classes.add(c);
			}
			create.close();
		});

		Scene sCreate = new Scene(gCreate);
		create.setScene(sCreate);
		create.show();

	}

	/**
	 * Creates a window that allows the user to edit the selected TableView index.
	 * 
	 * @param index
	 */
	public static void edit(int index) {

		Stage edit = new Stage();
		GridPane editGP = new GridPane();
		Button affirm = new Button("Save");

		Text nameChange = new Text("Enter new name: ");
		Text gradeChange = new Text("Select new grade: ");
		Text lengthChange = new Text("Select new length: ");

		TextField nameBox = new TextField();
		ComboBox<Object> gradeBox = new ComboBox<Object>(gradeOptions);
		ComboBox<Object> lengthBox = new ComboBox<Object>(lengthOptions);

		nameBox.setPromptText("Enter a name...");

		affirm.setOnAction(e -> {
			if (!nameBox.getText().isEmpty()) {
				classes.get(index).setName(nameBox.getText());
			}

			if (!(gradeBox.getSelectionModel().isEmpty())) {
				classes.get(index).setGrade(gradeBox.getSelectionModel().getSelectedItem().toString());
			}

			if (!(lengthBox.getSelectionModel().isEmpty())) {
				classes.get(index).setLength(lengthBox.getSelectionModel().getSelectedItem().toString());
			}

			edit.close();

			update();
		});

		editGP.setPadding(new Insets(10));
		editGP.setVgap(5);
		editGP.setHgap(5);

		editGP.add(nameChange, 1, 0);
		editGP.add(gradeChange, 1, 1);
		editGP.add(lengthChange, 1, 2);

		editGP.add(nameBox, 2, 0);
		editGP.add(gradeBox, 2, 1);
		editGP.add(lengthBox, 2, 2);

		editGP.add(affirm, 1, 3);

		Scene editSC = new Scene(editGP);

		edit.setScene(editSC);
		edit.show();

	}

	/**
	 * WIP - Updates the TableView anytime a class value is changed.
	 * 
	 * @param index
	 */
	public static void update() {
		lv.refresh();
	}

	/**
	 * Allows user to delete the selected index.
	 * 
	 * @param index
	 */
	public static void delete(int index) {

		classes.remove(index);
		update();

	}

	/**
	 * Only called when the user enters something wrong. Creates an error window
	 * with the type of error and related information.
	 * 
	 * @param errorType
	 * @param message
	 */
	public static void errorWindow(String errorType, String message) { // error window method
		Alert error = new Alert(AlertType.ERROR);
		error.setHeaderText(errorType);
		error.setContentText(message);

		error.showAndWait();
	}

	/**
	 * Only called when the user is making a risky decision. Creates a warning
	 * window with all relevant information.
	 * 
	 * @param warningType
	 * @param warningMessage
	 */
	public static void warningWindow(String warningType, String warningMessage) {
		Alert warning = new Alert(AlertType.INFORMATION);
		warning.setHeaderText(warningType);
		warning.setContentText(warningMessage);

		warning.showAndWait();
	}

	/**
	 * Launches the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch();
	}

}
