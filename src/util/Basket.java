package util;

import entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 21.07.2021.
 */
public class Basket {
    private static List<Item> items = new ArrayList<>();

    public static void printBasket(){
        for (Item item: items) {
            System.out.println(item.getName() + "----" + item.getFinalPrice());
        }
        System.out.println();
        System.out.println("Total price = " + calculatePrice());
    }
     static double calculatePrice(){
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }
}
