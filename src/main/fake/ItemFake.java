package main.fake;

import main.entity.Item;

/**
 * Created by Hayk on 30.07.2021.
 */
public class ItemFake {
    private int price;
    private String name;
    private String imageURL;

    public ItemFake(Item item){
        this.name=item.getName();
        this.price=item.getPrice();
        this.imageURL=item.getImageURL();
    }
}
