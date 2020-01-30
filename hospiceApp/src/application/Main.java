package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import objects.Patient;

public class Main extends Application {

	public TableView<Patient> tv;
	public static ObservableList<Patient> patients;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage s) {

		patients = FXCollections.observableArrayList();

		TableColumn<Patient, String> t1 = new TableColumn<Patient, String>("Name Thingy");
		t1.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));

		TableColumn<Patient, String> t2 = new TableColumn<Patient, String>("Age Thingy");
		t1.setCellValueFactory(new PropertyValueFactory<Patient, String>("age"));

		tv = new TableView<Patient>(patients);
		tv.prefHeightProperty().bind(s.heightProperty());
		tv.prefWidthProperty().bind(s.widthProperty());
		tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tv.setPlaceholder(new Label("Click File > Add new... to add a patient"));
		tv.getColumns().addAll(t1, t2);

		Menu file = new Menu("_File");
		MenuItem f1 = new MenuItem("Add new...");
		f1.setOnAction(e -> {
			patients.add(edit(new Patient()));
		});
		MenuItem f2 = new MenuItem("Close");
		f2.setOnAction(e -> {
			s.close();
		});
		file.getItems().addAll(f1, f2);

		Menu edit = new Menu("_Edit");
		MenuItem e1 = new MenuItem("Edit...");
		e1.setOnAction(e -> {
			edit(tv.getSelectionModel().getSelectedItem());
		});
		MenuItem e2 = new MenuItem("Delete");
		e1.setOnAction(e -> {
			delete(tv.getSelectionModel().getSelectedItem());
		});
		edit.getItems().addAll(e1, e2);

		MenuBar mb = new MenuBar();
		mb.getMenus().addAll(file, edit);

		GridPane gp = new GridPane();
		gp.add(mb, 0, 0);
		gp.add(tv, 0, 1);

		Scene sc = new Scene(gp);
		s.setScene(sc);
		s.setMaximized(true);
		s.show();

	}

	/**
	 * Allows the user to both create and edit a Patient.
	 * 
	 * @param p
	 * @return
	 */
	public static Patient edit(Patient p) {

		return p;

	}

	/**
	 * Allows the user to delete a Patient.
	 * 
	 * @param p
	 */
	public static void delete(Patient p) {
		patients.remove(p);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
