package ru.job4j.tracker;

public class ReplaceActon implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка");
        }
        return true;
    }
}
