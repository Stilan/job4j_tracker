package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class ShowItems implements UserAction{
    private final Output out;

    public ShowItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
       out.println("==== Show all items ====");
        List<Item> items  = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
           out.println(items.get(i));
        }
        return true;
    }
}
