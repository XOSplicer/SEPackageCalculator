package packagecalculator.model;

import com.google.gson.Gson;
import packagecalculator.json.Root;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Model implements ShippingCostCalculatable {

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
    public PackageCategory calculateBestPackageCategory(Package p) {
        if()
        return parseJson(pricesFilePath).stream() /* read in the json file and parse it to List<PackageCategory> */
                .filter(p::doesFit)             /* filter out the Categories that are not suitable p*/
                .min(Comparator.comparingDouble(PackageCategory::getPrice)) /* find the cheapest by the price, returns Optional<PackageCategory> */
                .orElse(PackageCategory.None); /* Fallback if no Category is suitable */
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

    @Override
    public double calcShippingCost(List<Item> items) {

        if(items.isEmpty()) {
          return Double.NaN;
        }

        /* check for negative values */
        if(items.stream().anyMatch(i -> i.getLength() < 0
                                        || i.getWidth() < 0
                                        || i.getHeight() < 0
                                        || i.getWeight() < 0)) {
            return Double.NaN;
        }

        /* rotate if needed */
        items.stream().forEach(i -> {
            int[] dim = new int[3];
            dim[0] = i.getLength();
            dim[1] = i.getWidth();
            dim[2] = i.getHeight();
            Arrays.sort(dim);
            i.setLength(dim[2]);
            i.setWidth(dim[1]);
            i.setHeight(dim[3]);
        });

        /* calculate Package dimensions */
        int maxLength = items.stream()
                                .max(Comparator.comparingInt(Item::getLength))
                                .get().getLength();
        int maxWidth = items.stream()
                                .max(Comparator.comparingInt(Item::getWidth))
                                .get().getWidth();
        int sumHeight = items.stream()
                                .mapToInt(Item::getHeight).sum();
        int sumWeight = items.stream()
                                .mapToInt(Item::getWeight).sum();

        /* rotate whole package if needed*/
        int[] dim = new int[3];
        dim[0] = maxLength;
        dim[1] = maxWidth;
        dim[2] = sumHeight;
        Arrays.sort(dim);
        int length = dim[3];
        int width = dim[2];
        int height = dim[1];

        /* create package for dimensions.
            convert mm to cm */
        Package p = new Package(height/10.0, length/10.0, width/10.0, sumWeight/10.0);
        PackageCategory pc = calculateBestPackageCategory(p);
        if (pc.getCategoryName().equals("none")) {
            return Double.NaN;
        }
        return pc.getPrice();
    }
}
