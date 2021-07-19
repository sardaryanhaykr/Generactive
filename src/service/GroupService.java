package service;

import entity.Group;
import repository.GroupRepository;
import java.util.List;

/**
 * Created by Hayk on 19.07.2021.
 */
public class GroupService {
    private GroupRepository groupRepository;

    public GroupService(){
        groupRepository = new GroupRepository();
    }

    public void add(Group group,Group parent){
        GroupUtil groupUtil=new GroupUtil();
        groupUtil.addRelation(group,parent);
        groupRepository.create(group);
    }

    public void update(Group group,int id){
        if (getById(id) != null){
            groupRepository.update(group,id);
        }
    }

    public void delete(int id){
        if (getById(id) != null){
            groupRepository.delete(id);
        }
    }

    public List<Group> getAll(){
        return groupRepository.findAll();
    }

    public List<Group> getRoots(){
        return groupRepository.findAllRoot();
    }

    public Group getById(int id){
        return groupRepository.findById(id);
    }
    private  class GroupUtil {

        private GroupUtil(){}

        public  void addRelation(Group group,Group parent){
            group.setParent(parent);
            if (parent != null){
                parent.getSubGroups().add(group);
            }
        }
    }
}