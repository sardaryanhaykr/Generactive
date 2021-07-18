package Util;

import Control.GroupControl;
import Control.ItemControl;
import Entity.Group;
import Entity.Item;

/**
 * Created by Hayk on 18.07.2021.
 */
public class ItemUtil {
    private static ItemControl itemControl=new ItemControl();
    private static GroupControl groupControl=new GroupControl();
    public static void create(Item item,int groupId){
        item.setId(ItemControl.getCurrentIndex());
        addRelation(item,groupControl.findById(groupId));
    }

    public static void addRelation(Item item, Group group){
        item.setParentGroup(group);
        group.getItems().add(item);
    }
}
