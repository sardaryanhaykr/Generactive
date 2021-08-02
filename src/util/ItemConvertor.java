package util;

import entity.Item;
import service.GroupService;
import validator.Validator;

/**
 * Created by Hayk on 02.08.2021.
 */
public final class ItemConvertor {
    private ItemConvertor(){}

    public static Item convert(String value,Item item){

        String[] vars=value.split(",");
        if (vars.length>5 || !Validator.isInt(vars[0]) || !Validator.isInt(vars[1]) || !Validator.isInt(vars[4])){
            return null;
        }

        item.setId(Integer.parseInt(vars[0]));
        item.setPrice(Integer.parseInt(vars[1]));
        item.setName(vars[2]);
        item.setImageURL(vars[3]);
        item.setParentGroup(new GroupService().getById(Integer.parseInt(vars[4])));
        return item;
    }

}
