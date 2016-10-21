package packagecalculator.model;

import packagecalculator.json.Category;

import java.util.Arrays;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class PackageCategory {

    public static final PackageCategory None = new PackageCategory("None", "None", -1.0, -1.0, -1.0, -1.0, -1.0, -1.0);

    private String serviceName;
    private String categoryName;
    private double maxHeight;
    private double maxLength;
    private double maxWidth;
    private double maxWeight;
    private double maxGirth;
    private double price;

    /**
     *
     * @param serviceName
     * @param categoryName
     * @param maxHeight
     * @param maxLength
     * @param maxWidth
     * @param maxWeight
     * @param maxGirth
     * @param price
     */
    public PackageCategory(String serviceName, String categoryName, double maxHeight,
                           double maxLength, double maxWidth, double maxWeight,
                           double maxGirth, double price) {
        this.serviceName = serviceName;
        this.categoryName = categoryName;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
        this.maxWeight = maxWeight;
        this.maxGirth = maxGirth;
        this.price = price;
    }

    /**
     *
     * @param serviceName
     * @param category
     */
    public PackageCategory(String serviceName, Category category) {
        this.serviceName = serviceName;
        this.categoryName = category.getCategoryName();
        this.maxHeight = category.getMaxHeight();
        this.maxLength = category.getMaxLength();
        this.maxWidth = category.getMaxWidth();
        this.maxWeight = category.getMaxWeight();
        this.maxGirth = category.getMaxGirth();
        this.price = category.getPrice();
    }

    public String getServiceName() {
    return serviceName;
}

    public String getCategoryName() {
        return categoryName;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getMaxGirth() {
        return maxGirth;
    }

    public double getPrice() {
        return price;
    }

    public boolean canHold(Package p) {

        return p.isValid()
                && p.getWidth() <= this.getMaxHeight()
                && p.getLength() <= this.getMaxLength()
                && p.getWidth() <= this.getMaxWidth()
                && p.getWeight() <= this.getMaxWeight()
                && p.getGirth() <= this.getMaxGirth();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(serviceName).append(" - ").append(categoryName).append("\n")
                        .append("Max. HxLxW: ").append(maxHeight).append("x")
                        .append(maxLength).append("x").append(maxWidth).append(" cm\n")
                        .append("Max. girth: ").append(maxGirth).append(" cm\n")
                        .append("Max. weight: ").append(maxWeight).append(" kg\n")
                        .append("Price: € ").append(price);
        return stringBuilder.toString();
    }

    public boolean isNone() {
        return this == PackageCategory.None;
    }

    private void rearrange() {
        double[] dim = new double[3];
        dim[0] = this.getMaxLength();
        dim[1] = this.getMaxWidth();
        dim[2] = this.getMaxHeight();
        Arrays.sort(dim);
        this.maxLength = dim[2];
        this.maxWidth = dim[1];
        this.maxHeight = dim[0];
    }

}
