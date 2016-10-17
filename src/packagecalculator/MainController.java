package packagecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


/**
 * The "glue" between the view defined by @file main.fxml and the model
 * Handles callbacks and holds references to the GUI Nodes
 * This class will be instantiated automatically by JavaFX upon loading the view
 */
public class MainController {

    private Model model;

    @FXML private TextField fieldHeight;
    @FXML private TextField fieldLength;
    @FXML private TextField fieldWidth;
    @FXML private TextField fieldWeight;

    @FXML private Button buttonCalculate;

    @FXML private Label labelResult;

    /**
     * Default no-parameter constructor needed by JavaFX
     * automatically called
     */
    public MainController() {
        model = new Model();
    }

    /**
     * callback method for the "Calculate" button
     * will be called automatically upon clicking it
     * defined as callback in @file main.fxml
     */
    @FXML
    private void buttonCalculateClicked() {
        try {
            double height = Double.parseDouble(fieldHeight.getText());
            double length = Double.parseDouble(fieldLength.getText());
            double width  = Double.parseDouble(fieldWidth.getText());
            double weight = Double.parseDouble(fieldWeight.getText());
            PackageCategory packageCategory = model.calulateBestPackageCategory(new Package(height, length, width, weight));
            labelResult.setText(packageCategory.toString());
            labelResult.setMinWidth(Region.USE_PREF_SIZE);
            labelResult.setMinHeight(Region.USE_PREF_SIZE);
        } catch (NumberFormatException e) {
            System.out.println("No valid input given!");
        }
    }
}
