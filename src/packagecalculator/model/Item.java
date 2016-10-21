package packagecalculator.model;

import java.util.Arrays;

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
     * @param weight in kg
     */
    public Item(int length, int width, int height, int weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.rearrange();
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

    public void rearrange() {
        int[] dim = new int[3];
        dim[0] = this.getLength();
        dim[1] = this.getWidth();
        dim[2] = this.getHeight();
        Arrays.sort(dim);
        this.setLength(dim[2]);
        this.setWidth(dim[1]);
        this.setHeight(dim[0]);
    }

    public boolean isValid() {
        if(this.getLength() < 0
                || this.getWidth() < 0
                || this.getHeight() < 0
                || this.getWeight() < 0) {
            return false;
        } else {
            return true;
        }
    }

}
