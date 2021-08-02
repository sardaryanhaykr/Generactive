package repository;

import entity.Item;
import db.FakeDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Hayk on 19.07.2021.
 */
public class ItemRepository implements CrudRepository<Item, Long> {
    private final List<Item> items;

    public ItemRepository() {
        items = FakeDatabase.getItems();
    }

    @Override
    public void create(Item item) {
        items.add(item);
    }

    @Override
    public void update(Item item, Long id) {
        Item item1 = findById(id);
        if (item.getPrice() != 0) {
            item1.setPrice(item.getPrice());
        }
        if (item.getName() != null) {
            item1.setName(item.getName());
        }
        if (item.getParentGroup() != null) {
            item1.setParentGroup(item.getParentGroup());
        }
        if (item.getImageURL() != null) {
            item1.setImageURL(item.getImageURL());
        }
    }

    @Override
    public void delete(Long id) {
        items.remove(findById(id));
    }

    public Item findById(long id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Item> findAll() {
        return items;
    }

    public Item findByName(String name) {
        Item item = items.stream()
                .filter(item1 -> name.equals(item1.getName()))
                .findFirst()
                .orElse(null);
        return item;
    }

    public List<Item> findHighestPricedItems() {
        double maxPrice = items.stream().max(Comparator.comparing(Item::getPrice)).get().getPrice();
        List<Item> result = items.stream()
                .filter(item -> item.getPrice() == maxPrice)
                .collect(Collectors.toList());
        return result;
    }

    public List<Item> findSmallestPricedItems() {
        double minPrice = items.stream()
                .min(Comparator.comparing(Item::getPrice))
                .get()
                .getPrice();
        List<Item> result = items.stream()
                .filter(item -> item.getPrice() == minPrice)
                .collect(Collectors.toList());
        return result;
    }

    public List<Item> findByPriceRange(double priceMin, double priceMax) {

        List<Item> result = items.stream()
                .filter(item -> item.getPrice() >= priceMin && item.getPrice() <= priceMax)
                .collect(Collectors.toList());
        return result;
    }
}
