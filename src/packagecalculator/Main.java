package packagecalculator;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import packagecalculator.json.Root;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;


public class Main extends Application {

    private final String pricesFilePath = "./res/prices.json";

    private TextField fieldHeight;
    private TextField fieldLength;
    private TextField fieldWidth;
    private TextField fieldWeight;

    private Button buttonCalculate;

    private Label labelResult;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 1000, 200);
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
            PackageCategory packageCategory = calulateBestPackageCategory(new Package(height, length, width, weight));
            labelResult.setText(packageCategory.toString());
            labelResult.setMinWidth(Region.USE_PREF_SIZE);
            labelResult.setMinHeight(Region.USE_PREF_SIZE);
        } catch (NumberFormatException e) {
            System.out.println("No valid input given!");
        }
    }

    private PackageCategory calulateBestPackageCategory(Package p) {
        List<PackageCategory> allCategories = parseJson(pricesFilePath);
        List<PackageCategory> fittingCategories = allCategories.stream().filter(
                category -> p.doesFit(category)
        ).collect(Collectors.toList());
        Optional<PackageCategory> optMin = fittingCategories.stream().min(Comparator.comparingDouble(PackageCategory::getPrice));
        return optMin.orElse(new PackageCategory("None", "None", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    }

    private List<PackageCategory> parseJson(String path) {
        List<PackageCategory> parsed = new ArrayList<>();
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset());
            //System.out.println(json);
            Gson gson = new Gson();
            Root root = gson.fromJson(json, Root.class);
            //System.out.println(root);
            for (int i = 0; i < root.getServices().length; i++) {
                for (int j = 0; j < root.getServices()[i].getCategories().length; j++) {
                    parsed.add(new PackageCategory(root.getServices()[i].getServiceName(), root.getServices()[i].getCategories()[j]));
                }
            }
            //System.out.println(parsed);
        } catch (IOException e) {
            System.out.println("Could not read prices.json!");
        } catch (NumberFormatException e) {
            System.out.println("Something went wrong while parsing prices.json!");
        }
        return parsed;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
