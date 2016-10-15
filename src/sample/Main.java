package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    private MainController controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Package Calculator");
        primaryStage.setScene(scene);

        controller = new MainController(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
