package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
       Item item = new Item();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
       String stringData = item.getCreated().format(formatter);
       System.out.println(stringData);
    }

}