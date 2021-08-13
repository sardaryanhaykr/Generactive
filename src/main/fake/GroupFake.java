package main.fake;

import main.entity.Group;

/**
 * Created by Hayk on 30.07.2021.
 */
public final class GroupFake {
    private  final String name;

    public GroupFake(Group group){
        this.name=group.getName();
    }

    public String getName(){
        return this.name;
    }
}
