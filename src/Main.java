import Control.GroupControl;
import Entity.Group;
import Util.GroupUtil;
import Util.Validator;

import java.util.Scanner;

public class Main {
   private static GroupControl groupControl=new GroupControl();

    private static String input(String message) {
        String string="";
        Scanner input_scanner = new Scanner(System.in);
        System.out.println( message);

            string = input_scanner.nextLine();

        input_scanner.close();
        return string;
    }
    static Group inputGroup(){
        Group group = new Group();
        String name="";
        do{
           name = input("Enter the name of group");
        } while (name.equals(""));

        group.setName(name);
        int parentId=0;
        String temp;
        boolean t=true;

        do{
            temp = input("Enter existing ID of parent group");
            t = Validator.isValidNumber(temp);
            if ( t ){
                parentId = Integer.parseInt(temp);
                if(parentId !=0 && groupControl.findById(parentId) != null){
                    t = false;
                }  else{
                    parentId = 0;
                }
            }
        }while (!t);
        GroupUtil.create(group,parentId);
        return group;
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
                 case "group":{
                     System.out.println("From group");
                 }
             }
             command="";
         }while (!command.toLowerCase().equals("exit"));

    }
}
