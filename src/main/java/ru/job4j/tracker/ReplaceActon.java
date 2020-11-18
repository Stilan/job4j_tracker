package ru.job4j.tracker;

public class ReplaceActon implements UserAction{
    private final Output out;

    public ReplaceActon(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Успешно");
        } else {
            out.println("Ошибка");
        }
        return true;
    }
}
