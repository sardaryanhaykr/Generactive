package Util;

import Control.GroupControl;
import Entity.Group;

/**
 * Created by Hayk on 18.07.2021.
 */
public  class GroupUtil {
    private static GroupControl groupControl=new GroupControl();

    public static void create(Group group,int parentId){
        Group group1=groupControl.findById(parentId);
        group.setId(GroupControl.getCurrentIndex());
        addRelation(group1,group);
    }

    public static void addRelation(Group parentGroup, Group subGroup){
        if(parentGroup != null){
            parentGroup.getSubGroups().add(subGroup);
            subGroup.setParent(parentGroup);
        }
    }
}
