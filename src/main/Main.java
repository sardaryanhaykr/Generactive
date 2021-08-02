package main;

import db.FakeDatabase;
import entity.GenerativeItem;
import entity.Group;
import entity.Item;
import entity.StockItem;
import service.GroupService;
import service.ItemService;
import util.ItemConvertor;
import validator.Validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static GroupService groupService = new GroupService();
    private static ItemService itemService = new ItemService();
    private static Scanner input_scanner = new Scanner(System.in);

    private static String input(String message) {
        System.out.println(message);
        return input_scanner.nextLine();
    }

    static void inputGroup() {
        Group group = new Group();
        String name;
        do {
            name = input("Enter the name of group");
        } while (name.equals(""));

        group.setName(name);
        int parentId = 0;
        String temp;
        boolean t;

        do {
            FakeDatabase.printGroupsId();
            temp = input("Enter existing ID of parent group");
            t = Validator.isValidNumber(temp);
            if (t) {
                parentId = Integer.parseInt(temp);
                if (parentId == 0 || groupService.getById(parentId) != null) {
                    t = true;
                } else {
                    t = false;
                    parentId = 0;
                }
            }
        } while (!t);
        groupService.add(group, groupService.getById(parentId));
    }

    public static void inputItem() {
        Item item = null;
        boolean t;
        String name;
        do {
            int inputKey;
            name = input("Enter the type of item: 1-Generative or 2-Stock");
            t = Validator.isValidNumber(name);
            if (t) {
                inputKey = Integer.parseInt(name);
                if (inputKey == 1) {
                    item = new GenerativeItem();
                } else if (inputKey == 2) {
                    item = new StockItem();
                } else {
                    t = false;
                }
            }
        } while (!t);
        do {
            name = input("Enter the name of item");
        } while (name.equals(""));
        item.setName(name);
        String imageURL;
        do {
            imageURL = input("Enter the image url of item");
        } while (imageURL.equals(""));
        item.setImageURL(imageURL);
        String temp;
        int price = 0;
        do {
            temp = input("Enter the price of item");
            t = Validator.isValidNumber(temp);
            if (t) {
                price = Integer.parseInt(temp);
            }
        } while (!t);
        item.setPrice(price);
        int groupId = 0;
        do {
            FakeDatabase.printGroupsId();
            temp = input("Enter existing ID of parent group");
            t = Validator.isValidNumber(temp);
            if (t) {
                groupId = Integer.parseInt(temp);
                if (groupId != 0 && groupService.getById(groupId) != null) {
                    t = true;
                } else {
                    groupId = 0;
                    t = false;
                }
            }
        } while (!t);
        itemService.add(item, groupService.getById(groupId));
    }

    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());

        groupService.add(new Group(1, "Group1", null), null);
        groupService.add(new Group(2, "Group2", null), null);
        groupService.add(new Group(3, "Group3", null), null);
        List<String> rows = new ArrayList<>();
        File file = new File("src/main/resources/item.csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                rows.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Please input the file path correctly");
        }
        for (String s : rows) {
            Item item = ItemConvertor.convert(s, new StockItem());
            if (item != null) {
                itemService.add(item, item.getParentGroup());
            }
        }

        String command;
        do {
            System.out.println("Please enter one of the commands");
            System.out.println("group----OR----1");
            System.out.println("item-----OR----2");
            System.out.println("show-----OR----3");
            System.out.println("exit-----OR----0");
            command = input("Enter command").toLowerCase();
            switch (command) {
                case "0": {
                    command = "exit";
                }
                break;
                case "1":
                case "group": {
                    inputGroup();
                }
                break;
                case "2":
                case "item": {
                    inputItem();
                }
                break;
                case "3":
                case "show": {
                    for (Group group : groupService.getRoots()) {
                        group.printContent("");
                    }
                }
                break;
            }

        } while (!command.toLowerCase().equals("exit"));
        input_scanner.close();
    }

}
