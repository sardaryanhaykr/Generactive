package db;

import entity.Group;
import entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 18.07.2021.
 */
public class FakeDatabase {
    private static List<Group> groups = new ArrayList<>();
    private static List<Item> items = new ArrayList<>();

    public static List<Group> getGroups() {
        return groups;
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void printGroupsId(){
        System.out.print("(");
        for (int i = 0; i < groups.size(); i++) {
            System.out.print(groups.get(i).getId());
            if (i < groups.size()-1){
                System.out.print(", ");
            }else {
                System.out.print(")");
            }
        }
    }
}
