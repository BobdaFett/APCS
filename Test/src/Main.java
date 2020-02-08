import javafx.*;
import javafx.application.Application;

public class Main extends Application {

    // working on it

    public static void main(String[] args) {
        Application.launch(args);
    }

        public void start(Stage s) {
            GridPane gp = new GridPane();
            Button b = new Button("Click this");
            gp.add(b, 0, 0,);

            Scene sc = new Scene(gp);
            s.setScene(sc);
            s.show();
        }
}
