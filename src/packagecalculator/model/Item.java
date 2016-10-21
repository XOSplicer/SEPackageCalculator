package packagecalculator.model;

/**
 * Created by felix on 21.10.16.
 */
public class Item {

    private int length;
    private int width;
    private int height;
    private int weight;

    public Item() {

    }


    /**
     *
     * @param length in mm
     * @param width in mm
     * @param height in mm
     * @param weight in mm
     */
    public Item(int length, int width, int height, int weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
