package BankAccount;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TestBankAccount extends Application {
	
	public static TableView<ManagedAccount> tv;
	
	@SuppressWarnings("unchecked")
	public void start(Stage s) throws Exception {
		
		TableColumn<ManagedAccount, String> tName = new TableColumn<ManagedAccount, String>("Name");
		tName.setCellValueFactory(new PropertyValueFactory<ManagedAccount, String>("name"));
		
		TableColumn<ManagedAccount, String> tBalance = new TableColumn<ManagedAccount, String>("Balance");
		tBalance.setCellValueFactory(new PropertyValueFactory<ManagedAccount, String>("balance"));
		
		Menu file = new Menu("_File");
		MenuItem file1 = new MenuItem("Create...");
		MenuItem file2 = new MenuItem("Exit");
		file.getItems().addAll(file1, file2);
		
		Menu edit = new Menu("_Edit");
		MenuItem edit1 = new MenuItem("Edit");
		MenuItem edit2 = new MenuItem("Delete");
		edit.getItems().addAll(edit1, edit2);
		
		MenuBar mb = new MenuBar();
		mb.getMenus().addAll(file, edit);
		
		tv = new TableView<ManagedAccount>();
		tv.prefHeightProperty().bind(s.heightProperty());
		tv.prefWidthProperty().bind(s.widthProperty());
		tv.getColumns().addAll(tName, tBalance);
		tv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		GridPane gp = new GridPane();
		gp.add(mb, 0, 0);
		gp.add(tv, 0, 1);
		
		Scene sc = new Scene(gp);
		s.setScene(sc);
		s.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}