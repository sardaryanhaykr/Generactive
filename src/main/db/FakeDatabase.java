package main.db;

import main.entity.Group;
import main.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 18.07.2021.
 */
public class FakeDatabase {
    private static final List<Group> groups = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();

    public static List<Group> getGroups() {
        return groups;
    }

    public static List<Item> getItems() {
        return items;
    }

    private static List<Integer> idList(){
        List<Integer> integers =new ArrayList<>();
        for (Group group: groups) {
            integers.add(group.getId());
        }
        return integers;
    }

    public static void printGroupsId(){
        idList().toString();
    }

    public static void clear(){
        groups.clear();
        items.clear();
    }
}
