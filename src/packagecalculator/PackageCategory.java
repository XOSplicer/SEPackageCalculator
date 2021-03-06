package packagecalculator;

import packagecalculator.json.Category;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class PackageCategory {

    private String serviceName;
    private String categoryName;
    private double maxHeight;
    private double maxLength;
    private double maxWidth;
    private double maxWeight;
    private double maxGirth;
    private double price;

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

}
