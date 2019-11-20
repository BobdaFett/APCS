package BankAccount;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("exports")
public class bankAccountFX extends Application {
	
	//TODO GridPanes
	
	public static StringProperty nameTest;
	public static String name;
	public static double balance;
	public static Text currentBalance;
	public static Button b1;
	public static Button b2;
	public static Button b3;
	public static Button b4;
	public static Button rename;
	public static Region VBoxRegion;
	public static Region VBoxRegion2;
	public static Region HBoxRegion;
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
		
		VBoxRegion = new Region();
		VBox.setVgrow(VBoxRegion, Priority.ALWAYS); //will take up as much space in a VBox
		
		VBoxRegion2 = new Region();
		VBox.setVgrow(VBoxRegion2, Priority.ALWAYS);
		
		HBoxRegion = new Region();
		HBox.setHgrow(HBoxRegion, Priority.ALWAYS); //will take up as much space in an HBox
		
		hb = new HBox(50, b1, b2, HBoxRegion);
		
		hb2 = new HBox(b3);
		
		vb = new VBox(currentBalance, VBoxRegion, hb, VBoxRegion2, hb2);
		
		base = new Scene(vb, 350, 90);
		
		stage.setScene(base);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
