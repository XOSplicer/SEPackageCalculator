package packagecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for the JavaFX application
 * Handles initialization
 */
public class Main extends Application {

    /**
     * Gets called when starting the application
     * Handles the loading of the scene
     * @param primaryStage the first stage being loaded, this is the scene will be placed in
     * @throws Exception because why not
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("res/main.fxml"));
        Scene scene = new Scene(root, 1000, 200); /*set initial window size*/
        primaryStage.setTitle("Package Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Default starting method for JavaFX
     * Will simply launch the application
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        launch(args);
    }
}
