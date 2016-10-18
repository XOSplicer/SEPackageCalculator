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

/**
 * Created by Felix Stegmaier on 17.10.2016.
 *
 * The Data Model for the Application.
 * It provides necessary data and actions to load, store, and interact with it.
 * Only used once in the Controller
 *
 * It provides access to the Package Category data defined by a json file
 */
public class Model {

    /**
     * The path to the json file that holds the information about the Package Services, their categories and prices
     */
    private final String pricesFilePath = "./res/prices.json";

    /**
     * Constructor
     */
    public Model() {

    }

    /**
     *
     * @param p the Package for which the cheapest Category out of the @file prices.json shall be found
     * @return the cheapest category for the package if present,
     *          else a default "None" category, hinting, no category is applicable for the package @param p
     */
    public PackageCategory calulateBestPackageCategory(Package p) {
        return parseJson(pricesFilePath).stream() /* read in the json file and parse it to List<PackageCategory> */
                .filter(p::doesFit)             /* filter out the Categories that are not suitable p*/
                .min(Comparator.comparingDouble(PackageCategory::getPrice)) /* find the cheapest by the price, returns Optional<PackageCategory> */
                .orElse(new PackageCategory("None", "None", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)); /* Fallback if no Category is suitable */
    }


    /**
     *
     * @param path The path to the json price file as String
     * @return List of Package categories, including service name, that are in the file
     */
    private List<PackageCategory> parseJson(String path) {
        /* initialize list to be filled */
        List<PackageCategory> parsed = new ArrayList<>();

        try {
            /* get the content of the json file,
            * might trow exception */
            String json = new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset());
            //System.out.println(json);

            /* use the Google gson library to atomatically parse the json file into the Classes given by the .json.* package,
            * might trow exception */
            Gson gson = new Gson();
            Root root = gson.fromJson(json, Root.class);
            //System.out.println(root);

            /* fill the list with Package Categories*/
            for (int i = 0; i < root.getServices().length; i++) { /* loop through the services */
                for (int j = 0; j < root.getServices()[i].getCategories().length; j++) { /* loop through the categories of each service */
                    /* add the Package category with service name to the list */
                    parsed.add(new PackageCategory(root.getServices()[i].getServiceName(),
                                                    root.getServices()[i].getCategories()[j]));
                }
            }
            //System.out.println(parsed);

        } catch (IOException e) {
            System.out.println("Could not read " + path + "!");
        } catch (NumberFormatException e) {
            System.out.println("Could not parse " + path + "!");
        } catch (Exception e) {
            /* unknown error */
            System.out.println("Something went wrong while parsing " + path + "!");
        }

        /* return the filled list*/
        return parsed;
    }
}
