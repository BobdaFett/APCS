package BankAccount;

import javafx.application.*;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

@SuppressWarnings("exports")
public class bankAccountFX extends Application {
	
	public static StringProperty nameTest;
	public static String name;
	public static Button b1;
	public static Button b2;
	public static Button b3;
	public static Button b4;
	public static Button rename;
	public static HBox hb;
	public static HBox hb2;
	public static VBox vb;
	public static Scene sc;
	public static Stage stage;
	
	public void start(Stage s) throws Exception {
		stage = new Stage();
		
		b1 = new Button("Create new bank account");
		b1.setOnAction(e -> {
			createAccount.open();
			//b1.setText("Rename account " + name + ".");
		});
		
		rename = new Button();
		rename.setOnAction(e -> {
			renameFX.open();
		});
		
		b2 = new Button("Withdraw");
		b2.setOnAction(e -> {
			withdrawFX.open();
		});
		
		b3 = new Button("Deposit");
		b3.setOnAction(e -> {
			depositFX.open();
		});
		
		b4 = new Button("Exit");
		b4.setOnAction(e -> {
			s.close();
		});
		
		hb = new HBox(20, b1, b2);
		
		hb2 = new HBox(20, b3);
		
		vb = new VBox(20, hb, hb2);
		
		sc = new Scene(vb, 300, 100);
		stage.setScene(sc);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
