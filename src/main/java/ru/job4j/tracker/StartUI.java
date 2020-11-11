package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void createItem2(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
    public static void createItem3(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка");
        }
    }
    public static void createItem4(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id =  input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка");
        }
    }
    public static void createItem5(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id =  input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }
    public static void createItem6(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                System.out.println(item[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select =input.askInt("Select: ");
            if (select == 0) {
               StartUI.createItem(input, tracker);
            } else if (select == 1) {
               StartUI.createItem2(input, tracker);
            } else if (select == 2) {
               StartUI.createItem3(input, tracker);
            } else if (select == 3) {
               StartUI.createItem4(input, tracker);
            } else if (select == 4) {
                StartUI.createItem5(input, tracker);
            } else if (select == 5) {
               StartUI.createItem6(input, tracker);
            } else if (select == 6) {
                System.out.println("==== Exit Program ====");
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
