package packagecalculator.json;

import java.util.Arrays;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class Service {

    private String serviceName;
    private Category[] categories;

    public Service() {

    }

    public Service(String serviceName, Category[] categories) {
        this.serviceName = serviceName;
        this.categories = categories;
    }

    public String getServiceName() { return serviceName; }

    public Category[] getCategories() { return categories; }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", categories=" + Arrays.toString(categories) +
                '}';
    }
}
