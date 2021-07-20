
import db.FakeDatabase;
import entity.Group;
import entity.Item;
import service.GroupService;
import service.ItemService;
import validator.Validator;

import java.util.Scanner;

public class Main {
   private static GroupService groupService = new GroupService();
   private static ItemService itemService = new ItemService();
    private static Scanner input_scanner = new Scanner(System.in);

    private static String input(String message) {
        System.out.println( message);
        String string = input_scanner.nextLine();
        return string;
    }

    static void inputGroup(){
        Group group = new Group();
        String name="";
        do{
           name = input("Enter the name of group");
        } while (name.equals(""));

        group.setName(name);
        int parentId = 0;
        String temp;
        boolean t = true;

        do{
            FakeDatabase.printGroupsId();
            temp = input("Enter existing ID of parent group");
            t = Validator.isValidNumber(temp);
            if ( t ){
                parentId = Integer.parseInt(temp);
                if(parentId !=0 && groupService.getById(parentId) != null){
                    t = true;
                }  else{
                    parentId = 0;
                }
            }
        }while (!t);
        groupService.add(group,groupService.getById(parentId));
    }

    public static void inputItem(){
        Item item = new Item();
        String name="";
        do{
            name = input("Enter the name of item");
        } while (name.equals(""));
        item.setName(name);
        String imageURL="";
        do{
            imageURL = input("Enter the image url of item");
        } while (imageURL.equals(""));
        item.setImageURL(imageURL);
        String temp;
        boolean t = true;
        int price=0;
        do{
            temp = input("Enter the price of item");
            t = Validator.isValidNumber(temp);
            if ( t ){
                price = Integer.parseInt(temp);
            }
        } while (!t);
        item.setPrice(price);
        t = true;
        int groupId = 0;
        do{
            FakeDatabase.printGroupsId();
            temp = input("Enter existing ID of parent group");
            t = Validator.isValidNumber(temp);
            if ( t ){
                groupId = Integer.parseInt(temp);
                if(groupId !=0 && groupService.getById(groupId) != null){
                    t = true;
                }  else{
                    groupId = 0;
                }
            }
        }while (!t);
        itemService.add(item,groupService.getById(groupId));
    }

    public static void main(String[] args) {

        String command;

         do{
             System.out.println("Please enter one of the commands");
             System.out.println("group");
             System.out.println("item");
             System.out.println("show");
             System.out.println("exit");
                command =input("Enter command");
             switch (command){
                 case "group" : {
                     inputGroup();
                 }break;
                 case "item" : {
                    inputItem();
                 }break;
                 case "show":{
                     for (Group group: groupService.getRoots()) {
                         group.printContent();
                     }
                 }break;
             }

         }while (!command.toLowerCase().equals("exit"));
         input_scanner.close();
    }

}
