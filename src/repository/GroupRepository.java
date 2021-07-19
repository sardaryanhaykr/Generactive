package repository;

import entity.Group;
import db.FakeDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hayk on 19.07.2021.
 */
public class GroupRepository implements CrudRepository<Group,Integer> {

    private List<Group> groups;

    public GroupRepository(){
        groups = FakeDatabase.getGroups();
    }
    @Override
    public void create(Group group) {
        groups.add(group);
    }

    @Override
    public void update(Group group, Integer id) {
        Group group1=findById(id);
        if(group.getName() != null){
            group1.setName(group.getName());
        }
        if(group.getParent() != null){
            group1.setParent(group.getParent());
        }
        if(group.getSubGroups() != null){
            group1.setSubGroups(group.getSubGroups());
        }
        if(group.getItems() != null){
            group1.setItems(group.getItems());
        }
    }

    @Override
    public void delete(Integer id) {
       groups.remove(findById(id));
    }

    public Group findById(int id){
        for (Group group: groups) {
            if (group.getId() == id){
                return group;
            }
        }
        return null;
    }

    public List<Group> findAll(){
        return groups;
    }

    public List<Group> findAllRoot(){
        List<Group> groups1=new ArrayList<>();
        for (Group group: groups) {
            if (group.getParent() == null){
                groups1.add(group);
            }
        }
        return groups1;
    }
}
