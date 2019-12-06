package BankAccount;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
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
	public static Button renameButton;
	public static Scene base;
	public static Stage stage;
	public static GridPane gp;
	
	public void start(Stage s) throws Exception {
		stage = new Stage();
		
		currentBalance = new Text("Your current balance is $0.00");
		
		b1 = new Button("_Create new bank account");
		b1.setOnAction(e -> { createAccount(); });
		
		renameButton = new Button();
		renameButton.setOnAction(e -> { rename(); });
		
		b2 = new Button("_Withdraw");
		b2.setOnAction(e -> { withdrawFX.open(); });
		
		b3 = new Button("_Deposit");
		b3.setOnAction(e -> { depositFX.open(); });
		
		b4 = new Button("_Exit");
		b4.setOnAction(e -> { s.close(); });
		
		gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 0, 1);
		gp.add(b4, 1, 1);
		
		gp.setPadding(new Insets(15));
		gp.setVgap(10);
		gp.setHgap(10);
		
		base = new Scene(gp);
		
		stage.setScene(base);
		stage.show();
		
	}
	
	public static void createAccount() {
		TextArea ta = new TextArea();
		ta.setPrefHeight(12);
		ta.setPrefWidth(235);
		
		
		Button affirm = new Button("_Submit");
		affirm.setOnAction(e -> {
			name = ta.getText();
			renameButton.setText("_Rename account " + name);
			gp.getChildren().remove(b1);
			gp.add(renameButton, 0, 0);
			stage.setScene(base);
		});
		
		affirm.setDefaultButton(true);
		
		GridPane createGP = new GridPane();
		createGP.setPadding(new Insets(10));
		createGP.setVgap(5);
		createGP.setHgap(7);
		
		createGP.add(affirm, 1, 0);
		createGP.add(ta, 0, 0);
		
		Scene create = new Scene(createGP, 315, 55);
		
		ta.setPromptText("Enter a new name...");
		
		stage.setScene(create);
	}
	
	public static void rename() {
		TextArea renameTA = new TextArea();
		renameTA.setPromptText("Enter a new name...");
		renameTA.setPrefHeight(12);
		renameTA.setPrefWidth(235);
		
		Button affirm = new Button("Submit");
		affirm.setDefaultButton(true);
		affirm.setOnAction(e -> {
			name = renameTA.getText();
			renameButton.setText("Rename account " + name);
			gp.getChildren().remove(renameButton);
			gp.add(renameButton, 0, 0);
			stage.setScene(base);
		});
		
		GridPane renameGP = new GridPane();
		renameGP.setPadding(new Insets(10));
		renameGP.setVgap(5);
		renameGP.setHgap(7);
		
		renameGP.add(renameTA, 0, 0);
		renameGP.add(affirm, 0, 1);
		
		Scene renameSC = new Scene(renameGP);
		
		stage.setScene(renameSC);
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
	
}
