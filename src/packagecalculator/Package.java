package packagecalculator;

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
     * @return
     */
    public double getGirth() {
        return 1*length + 2*width + 2*height;
    }

    /**
     *
     * @param category
     * @return
     */
    public boolean doesFit(PackageCategory category) {
        return height <= category.getMaxHeight()
                && length <= category.getMaxLength()
                && width <= category.getMaxWidth()
                && weight <= category.getMaxWeight()
                && getGirth() <= category.getMaxGirth();
    }

}
