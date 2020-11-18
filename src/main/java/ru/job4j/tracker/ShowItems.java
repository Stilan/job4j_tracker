package ru.job4j.tracker;

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
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
           out.println(items[i]);
        }
        return true;
    }
}
