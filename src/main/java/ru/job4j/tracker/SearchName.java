package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class SearchName implements UserAction{
    private final Output out;

    public SearchName(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(name);
        // Item[] item = tracker.findByName(name);
        if (item.size() > 0) {
            for (int i = 0; i < item.size(); i++) {
                out.println(item.get(i));
            }
        } else {
                out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
