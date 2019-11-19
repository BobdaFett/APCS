package BankAccount;

import javafx.application.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

@SuppressWarnings("exports")
public class bankAccountFX extends Application {
	
	public static StringProperty nameTest;
	public static String name;
	public static double balance;
	public static Text currentBalance;
	public static Button b1;
	public static Button b2;
	public static Button b3;
	public static Button b4;
	public static Button rename;
	public static Region r2;
	public static HBox hb;
	public static HBox hb2;
	public static VBox vb;
	public static Scene base;
	public static Stage stage;
	
	public void start(Stage s) throws Exception {
		stage = new Stage();
		
		currentBalance = new Text("Your current balance is $0.00");
		
		b1 = new Button("_Create new bank account");
		b1.setOnAction(e -> { createAccount.create(); });
		
		rename = new Button();
		rename.setOnAction(e -> { renameFX.rename(); });
		
		b2 = new Button("_Withdraw");
		b2.setOnAction(e -> { withdrawFX.open(); });
		
		b3 = new Button("_Deposit");
		b3.setOnAction(e -> { depositFX.open(); });
		
		b4 = new Button("_Exit");
		b4.setOnAction(e -> { s.close(); });
		
		Region r = new Region();
		VBox.setVgrow(r, Priority.ALWAYS); //will take up as much space in a VBox
		
		r2 = new Region();
		HBox.setHgrow(r2, Priority.ALWAYS); //will take up as much space in an HBox
		
		Region r3 = new Region();
		VBox.setVgrow(r3, Priority.ALWAYS);
		
		hb = new HBox(b1, r2, b2);
		
		hb2 = new HBox(b3);
		
		vb = new VBox(currentBalance, r3, hb, r, hb2);
		
		base = new Scene(vb, 300, 90);
		
		stage.setScene(base);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
