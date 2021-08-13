package main.entity;

/**
 * Created by Hayk on 21.07.2021.
 */
public class StockItem extends Item {

    @Override
    public double calculatePrice(Configuration configuration) {
        return getPrice()*configuration.getResolution().coefficient;
    }
}
