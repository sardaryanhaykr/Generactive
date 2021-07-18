package Control;

import Entity.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 15.07.2021.
 */
public class GroupControl {
    private List<Group> groups;
    private static int currentIndex=1000;

    public GroupControl(){
        groups = new ArrayList<>();
    }

    public void add(Group group){
        if(findByName(group.getName())!= null){
            groups.add(group);
            ++currentIndex;
        }
    }

    public void delete(int id){
        Group group = findById(id);
        if(group != null){
            groups.remove(findById(id));
        }
    }

    public Group findByName(String name){
        for (Group group:groups) {
            if(group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }

    public Group findById(int id){
        for (Group group:groups) {
            if(group.getId() == id){
                return group;
            }
        }
        return null;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
