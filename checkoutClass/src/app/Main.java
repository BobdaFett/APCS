package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This is a class that has finally started working...
 *
 * @author Lucas Vas
 */

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("This is a test");
        Application.launch(args);
        System.out.println("If this prints then it worked.");
    }

    public void start(Stage s) throws Exception {
        GridPane gp = new GridPane();
        Button test = new Button();

        gp.add(test, 0, 0);
        Scene sc = new Scene(gp);
        s.setScene(sc);
        s.show();
    }
}