
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
         return input_scanner.nextLine();
    }

    static void inputGroup(){
        Group group = new Group();
        String name;
        do{
           name = input("Enter the name of group");
        } while (name.equals(""));

        group.setName(name);
        int parentId = 0;
        String temp;
        boolean t;

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
        String name;
        do{
            name = input("Enter the name of item");
        } while (name.equals(""));
        item.setName(name);
        String imageURL;
        do{
            imageURL = input("Enter the image url of item");
        } while (imageURL.equals(""));
        item.setImageURL(imageURL);
        String temp;
        boolean t;
        int price=0;
        do{
            temp = input("Enter the price of item");
            t = Validator.isValidNumber(temp);
            if ( t ){
                price = Integer.parseInt(temp);
            }
        } while (!t);
        item.setPrice(price);
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
                    t = false;
                }
            }
        }while (!t);
        itemService.add(item,groupService.getById(groupId));
    }

    public static void main(String[] args) {

        String command;

         do{
             System.out.println("Please enter one of the commands");
             System.out.println("group----OR----1");
             System.out.println("item-----OR----2");
             System.out.println("show-----OR----3");
             System.out.println("exit-----OR----0");
                command =input("Enter command").toLowerCase();
             switch (command){
                 case "0":{
                     command = "exit";
                 }break;
                 case "1":
                 case "group" : {
                     inputGroup();
                 }break;
                 case "2":
                 case "item" : {
                    inputItem();
                 }break;
                 case "3":
                 case "show":{
                     for (Group group: groupService.getRoots()) {
                         group.printContent("");
                     }
                 }break;
             }

         }while (!command.toLowerCase().equals("exit") );
         input_scanner.close();
    }

}
