package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    private TextField FieldHeight;
    private TextField FieldLength;
    private TextField FieldWidth;
    private TextField FieldWeight;

    private Button ButtonCalculate;

    private Label LabelResult;

    public MainController(Scene scene) {
        FieldHeight = (TextField) scene.lookup("#FieldHeight");
        FieldLength = (TextField) scene.lookup("#FieldLength");
        FieldWeight = (TextField) scene.lookup("#FieldWidth");
        FieldWeight = (TextField) scene.lookup("#FieldWeight");

        ButtonCalculate = (Button) scene.lookup("#ButtonCalculate");
        ButtonCalculate.setOnAction(event -> buttonCalculateClicked(event));

        LabelResult = (Label) scene.lookup("#LabelResult");
    }

    private void buttonCalculateClicked(ActionEvent event) {
        //TODO implement
    }
}
