package packagecalculator;

import com.google.gson.Gson;
import packagecalculator.json.Root;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Felix Stegmaier on 17.10.2016.
 */
public class Model {

    private final String pricesFilePath = "./res/prices.json";

    public PackageCategory calulateBestPackageCategory(Package p) {
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
            System.out.println("Could not read " + path + "!");
        } catch (NumberFormatException e) {
            System.out.println("Something went wrong while parsing " + path + "!");
        }
        return parsed;
    }
}
