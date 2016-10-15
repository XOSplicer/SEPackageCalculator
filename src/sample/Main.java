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

    private TextField fieldHeight;
    private TextField fieldLength;
    private TextField fieldWidth;
    private TextField fieldWeight;

    private Button buttonCalculate;

    private Label labelResult;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Package Calculator");
        primaryStage.setScene(scene);

        fieldHeight = (TextField) scene.lookup("#FieldHeight");
        fieldLength = (TextField) scene.lookup("#FieldLength");
        fieldWidth = (TextField) scene.lookup("#FieldWidth");
        fieldWeight = (TextField) scene.lookup("#FieldWeight");

        buttonCalculate = (Button) scene.lookup("#ButtonCalculate");
        buttonCalculate.setOnAction(event -> buttonCalculateClicked(event));

        labelResult = (Label) scene.lookup("#LabelResult");

        primaryStage.show();

    }

    private void buttonCalculateClicked(ActionEvent event) {
        try {
            double height = Double.parseDouble(fieldHeight.getText());
            double length = Double.parseDouble(fieldLength.getText());
            double width  = Double.parseDouble(fieldWidth.getText());
            double weight = Double.parseDouble(fieldWeight.getText());
            double packagePrize = calulatePackagePrize(height, length, width, weight);
            labelResult.setText("€ " + Double.toString(packagePrize));
        } catch (NumberFormatException e) {
            System.out.println("No valid input given!");
        }


    }

    private double calulatePackagePrize(double height, double length, double width, double weight) {
        //TODO implement, parse json, find fitting category for each package service, find cheapest one
        return 42.0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
