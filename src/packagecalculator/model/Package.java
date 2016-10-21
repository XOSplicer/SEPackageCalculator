package packagecalculator.model;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class Package {

    private double height;
    private double length;
    private double width;
    private double weight;

    /**
     *
     * @param height
     * @param length
     * @param width
     * @param weight
     */
    public Package(double height, double length, double width, double weight) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
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

}
