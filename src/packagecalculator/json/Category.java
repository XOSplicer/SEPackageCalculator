package packagecalculator.json;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class Category {

    private String categoryName;
    private double maxHeight;
    private double maxLength;
    private double maxWidth;
    private double maxWeight;
    private double maxGirth;
    private double price;

    /**
     *
     */
    public Category() {

    }

    /**
     *
     * @param categoryName
     * @param maxHeight
     * @param maxLength
     * @param maxWidth
     * @param maxWeight
     * @param maxGirth
     * @param price
     */
    public Category(String categoryName, double maxHeight, double maxLength,
                    double maxWidth, double maxWeight, double maxGirth, double price) {
        this.categoryName = categoryName;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;
        this.maxWeight = maxWeight;
        this.maxGirth = maxGirth;
        this.price = price;
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", maxHeight=" + maxHeight +
                ", maxLength=" + maxLength +
                ", maxWidth=" + maxWidth +
                ", maxWeight=" + maxWeight +
                ", maxGirth=" + maxGirth +
                ", price=" + price +
                '}';
    }
}
