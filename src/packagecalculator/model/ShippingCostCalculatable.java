package packagecalculator.model;

import java.util.List;

/**
 * Created by felix on 21.10.16.
 */
public interface ShippingCostCalculatable {

    double calcShippingCosts(List<Item> items);

}
