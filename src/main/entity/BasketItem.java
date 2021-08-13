package main.entity;

/**
 * Created by Hayk on 30.07.2021.
 */
public class BasketItem {
    private final Item item;
    private final Configuration configuration;
    public BasketItem(Item item,Configuration configuration){
        this.item=item;
        this.configuration=configuration;
    }
    public double getPrice(){
        return item.calculatePrice(configuration);
    }

    public String getName(){
        return item.getName();
    }
}
