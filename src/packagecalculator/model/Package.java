package packagecalculator.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class Package {

    public final static Package None = new Package(-1.0, -1.0, -1.0, -1.0);

    //TODO use is Valid ind validation instead

    private boolean inNone;

    private double height;
    private double length;
    private double width;
    private double weight;

    /**
     *
     * @param height in cm
     * @param length in cm
     * @param width in cm
     * @param weight in kg
     */
    public Package(double height, double length, double width, double weight) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.rearrange();
    }

    public Package(List<Item> items) {

        if(items.isEmpty()) {
            this.makeInvalid();
            return;
        }

        if(items.stream().anyMatch(i -> !i.isValid())) {
            this.makeInvalid();
            return;
        }

        /* rotate if needed */
        items.stream().forEach(Item::rearrange);

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

        /* set parameters, convert from mm to cm*/
        this.length = maxLength / 10.0;
        this.width = maxWidth / 10.0;
        this.height = sumHeight / 10.0;
        this.weight = sumWeight;

        this.rearrange();

    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getWeight() {
        return weight;
    }

    /**
     *
     * @return the girth calculated by 1*length + 2*width + 2*height
     */
    public double getGirth() {
        return 1*length + 2*width + 2*height;
    }

    /**
     *
     * @param category PackageCategory to be checked against
     * @return whether or not the package fits into the constraints of the given category
     */
    /* functionality is moved to PackageCategory */
    public boolean doesFit(PackageCategory category) {
        return category.canHold(this);
    }

    public boolean isValid() {
        return !(this.getLength() < 0
                || this.getWidth() < 0
                || this.getHeight() < 0
                || this.getWeight() < 0);
    }

    public void rearrange() {
        double[] dim = new double[3];
        dim[0] = this.getLength();
        dim[1] = this.getWidth();
        dim[2] = this.getHeight();
        Arrays.sort(dim);
        this.length = dim[2];
        this.width = dim[1];
        this.height = dim[0];
    }

    private void makeInvalid() {
        this.height = -1.0;
        this.length = -1.0;
        this.width = -1.0;
        this.weight = -1.0;
    }

}
