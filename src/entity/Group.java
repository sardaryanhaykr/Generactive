package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 15.07.2021.
 */
public class Group {
    private int id;
    private String name;
    private Group parent;
    private List<Group> subGroups;
    private List<Item> items;
    private int idSequance=1000;

    public Group( String name, Group parent, List<Group> subGroups) {
        this.id = ++idSequance;
        this.name = name;
        this.parent = parent;
        this.subGroups = subGroups;
        items = new ArrayList<>();
        subGroups = new ArrayList<>();
    }

    public Group( String name, Group parent) {
        this(name,parent,null);
    }

    public Group(String name){
        this(name,null,null);
    }

    public Group(){
        this(null,null,null);
    }

    public void printContent(){
        System.out.println(this.getName());
        System.out.print("    ");
        if(subGroups != null){
            for (Group group:subGroups) {
                group.printContent();
            }
        }
        if (items != null){
            for (Item item: items) {
                System.out.println("-"+item.getName());
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(List<Group> subGroups) {
        this.subGroups = subGroups;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != group.id) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (parent != null ? !parent.equals(group.parent) : group.parent != null) return false;
        if (subGroups != null ? !subGroups.equals(group.subGroups) : group.subGroups != null) return false;
        return items != null ? items.equals(group.items) : group.items == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (subGroups != null ? subGroups.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
