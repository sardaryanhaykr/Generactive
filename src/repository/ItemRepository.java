package repository;

import entity.Item;
import db.FakeDatabase;

import java.util.List;

/**
 * Created by Hayk on 19.07.2021.
 */
public class ItemRepository implements CrudRepository<Item,Long> {
    private List<Item> items;

    public ItemRepository(){
        items = FakeDatabase.getItems();
    }
    @Override
    public void create(Item item) {
        items.add(item);
    }

    @Override
    public void update(Item item, Long id) {
        Item item1 = findById(id);
        if (item.getPrice() != 0){
            item1.setPrice(item.getPrice());
        }
        if (item.getName() != null){
            item1.setName(item.getName());
        }
        if (item.getParentGroup() != null){
            item1.setParentGroup(item.getParentGroup());
        }
        if (item.getImageURL() != null){
            item1.setImageURL(item.getImageURL());
        }
    }

    @Override
    public void delete(Long id) {
        items.remove(findById(id));
    }

    public Item findById(long id){
        for (Item item: items) {
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public List<Item> findAll(){
        return items;
    }
}
