package entity;

import entity.Item;
import fake.ItemFake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 21.07.2021.
 */
public class Basket {
    private final List<BasketItem> items = new ArrayList<>();

    public void addItems(BasketItem item) {
        items.add(item);
    }

    public double calculatePrice() {
        double totalPrice=0;
        for (BasketItem item:items){
            totalPrice+=item.getPrice();
        }
        return totalPrice;
    }

    public void printContent() {
        for (BasketItem item : items) {
            System.out.println(item.getName() + "----" + item.getPrice());
        }
        System.out.println();
        System.out.println("Total price = " + calculatePrice());
    }
}
