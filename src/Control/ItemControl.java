package Control;

import Entity.Group;
import Entity.Item;
import Util.GroupUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 15.07.2021.
 */
public class ItemControl {
    private List<Item> items;
    private GroupControl groupControl;
    private static long currentIndex=1000;


    public ItemControl(){
        groupControl=new GroupControl();
        items=new ArrayList<>();
    }

    public void add(Item item){
        if(!isExist(item)){
            items.add(item);
            ++currentIndex;
        }
    }

    public void delete(long id){
        Item item=findById(id);
        if(item != null){
            items.remove(item);
        }
    }

    public Item findById(long id){
        for(Item item:items){
            if(id == item.getId()){
                return item;
            }
        }
        return null;
    }

    public boolean isExist(Item item1){
        for(Item item:items){
            if(item.equals(item1)){
                return true;
            }
        }
        return false;
    }

    public static long getCurrentIndex() {
        return currentIndex;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
