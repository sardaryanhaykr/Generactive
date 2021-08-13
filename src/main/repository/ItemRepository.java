package main.repository;

import main.entity.Item;
import main.db.FakeDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Item item1=null;
        if(findById(id).isPresent()){
        item = findById(id).get();
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
    }

    @Override
    public void delete(Long id) {
        if (findById(id).isPresent()) {
            items.remove(findById(id).get());
        }
    }

    public Optional<Item> findById(long id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public List<Item> findAll() {
        return items;
    }

    public Optional<Item> findByName(String name) {
        return items.stream()
                .filter(item1 -> name.equals(item1.getName()))
                .findFirst();


    }

    public List<Item> findHighestPricedItems() {
        double maxPrice = items.stream().max(Comparator.comparing(Item::getPrice)).get().getPrice();
        return items.stream()
                .filter(item -> item.getPrice() == maxPrice)
                .collect(Collectors.toList());

    }

    public List<Item> findSmallestPricedItems() {
        double minPrice = items.stream()
                .min(Comparator.comparing(Item::getPrice))
                .get()
                .getPrice();
        return items.stream()
                .filter(item -> item.getPrice() == minPrice)
                .collect(Collectors.toList());

    }

    public List<Item> findByPriceRange(double priceMin, double priceMax) {

        return items.stream()
                .filter(item -> item.getPrice() >= priceMin && item.getPrice() <= priceMax)
                .collect(Collectors.toList());

    }
}
