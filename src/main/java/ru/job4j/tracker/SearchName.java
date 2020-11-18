package ru.job4j.tracker;

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
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                out.println(item[i]);
            }
        } else {
                out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
