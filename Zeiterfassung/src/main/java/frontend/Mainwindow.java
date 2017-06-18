package frontend;

import backend.Auftraggeber;
import backend.Bereich;
import backend.Identitaet;
import backend.Projekt;
import com.google.gson.Gson;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by sellmer on 08.06.17.
 */
public class Mainwindow extends Application{

    Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*
        Simons Tests START
         */

        // Erstellt 2 Identitäts Objekte
        System.out.println(Identitaet.getObjectsFromJson("[{name:\"test1\"},{name:\"test2\"}]"));

        // Erstellt 1 Projekt Objekt, macht es zu einem JSON String und anschließend wieder zu einem Projekt Objekt
        Projekt projekt = new Projekt("Test", new Auftraggeber("hans"),new Bereich("FH"));
        Gson gson = new Gson();
        String jsonString = gson.toJson(projekt);
        System.out.println(jsonString);


        /*
        Simons Tests ENDE
         */

        primaryStage.setTitle("Zeiterfassung");
        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
