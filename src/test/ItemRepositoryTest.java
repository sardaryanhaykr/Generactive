package test;

import main.entity.GenerativeItem;
import main.entity.Group;
import main.entity.Item;
import main.repository.GroupRepository;
import main.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hayk on 14.08.2021.
 */
class ItemRepositoryTest {
    GroupRepository groupRepository = new GroupRepository();
    ItemRepository itemRepository = new ItemRepository();
    Group group = new Group("ParentGroup");
    Item item = new GenerativeItem("TestItem", "TestImg", 10, group, 2);

    @BeforeEach
    public void clearDB() {
        itemRepository.clear();
        groupRepository.clear();
    }

    @Test
    @DisplayName("CreateItem")
    void create() {
        itemRepository.create(item);
        assertEquals(item, itemRepository.findById(item.getId()).get());
    }

    @Test
    @DisplayName("UpdateItem")
    void update() {
        itemRepository.create(item);
        Item item1 = new GenerativeItem("UpdateName", "UpdateUrl", 20, group, 2);
        itemRepository.update(item1, item.getId());
        item1.setId(item.getId());
        assertEquals(item1, itemRepository.findById(item.getId()).get());
    }

    @Test
    @DisplayName("DeleteItem")
    void delete() {
        itemRepository.create(item);
        assertTrue(itemRepository.findById(item.getId()).isPresent());
    }

    @Test
    @DisplayName("FindItemById")
    void findById() {
        itemRepository.create(item);
        assertTrue(itemRepository.findById(item.getId()).isPresent());
    }

    @Test
    @DisplayName("FindAllItems")
    void findAll() {
        itemRepository.create(item);
        assertTrue(!itemRepository.findAll().isEmpty());
    }

    @Test
    @DisplayName("FindeItemByName")
    void findByName() {
        itemRepository.create(item);
        assertEquals(item, itemRepository.findByName(item.getName()).get());
    }

    @Test
    @DisplayName("FindHighestPricedItems")
    void findHighestPricedItems() {
        Item item1 = new GenerativeItem("UpdateName", "UpdateUrl", 20, group, 2);
        itemRepository.create(item);
        itemRepository.create(item1);
        assertEquals(item1, itemRepository.findHighestPricedItems().get(0));
    }

    @Test
    @DisplayName("findSmallestPricedItems")
    void findSmallestPricedItems() {
        Item item1 = new GenerativeItem("UpdateName", "UpdateUrl", 20, group, 2);
        itemRepository.create(item);
        itemRepository.create(item1);
        assertEquals(item, itemRepository.findSmallestPricedItems().get(0));
    }

    @Test
    @DisplayName("FindByPriceRange")
    void findByPriceRange() {
        Item item1 = new GenerativeItem("UpdateName", "UpdateUrl", 20, group, 2);
        itemRepository.create(item);
        itemRepository.create(item1);
        assertEquals(item, itemRepository.findByPriceRange(7, 15).get(0));
        assertEquals(item1, itemRepository.findByPriceRange(15, 100).get(0));
    }

    @Test
    @DisplayName("ClearItems")
    void clear() {
        itemRepository.create(item);
        itemRepository.clear();
        assertTrue(itemRepository.findAll().isEmpty());
    }

}