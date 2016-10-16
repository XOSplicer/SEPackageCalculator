package packagecalculator.json;

import java.util.Arrays;

/**
 * Created by Felix Stegmaier on 16.10.2016.
 */
public class Root {

    private Service[] services;

    public Root() {

    }

    public Root(Service[] services) {
        this.services = services;
    }

    public Service[] getServices() { return services; }

    @Override
    public String toString() {
        return "Root{" +
                "services=" + Arrays.toString(services) +
                '}';
    }
}
