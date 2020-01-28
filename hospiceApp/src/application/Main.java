package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

		GridPane gp = new GridPane();
		gp.add(tv, 0, 0);

		Scene sc = new Scene(gp);
		s.setScene(sc);
		s.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
