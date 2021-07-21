package entity;

import entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 21.07.2021.
 */
public class Basket {
    private List<Item> items = new ArrayList<>();
    private double totalPrice;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        totalPrice = calculateTotalPrice();
    }

    public void printContent() {
        for (Item item : items) {
            System.out.println(item.getName() + "----" + item.getFinalPrice());
        }
        System.out.println();
        System.out.println("Total price = " + totalPrice);
    }

    private double calculateTotalPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.calculatePrice(item.getPrice());
        }
        return price;
    }
}
