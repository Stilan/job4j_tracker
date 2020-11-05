package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {

        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] items2 = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                items2[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int intId = indexOf(id);
        item.setId(id);
        if (intId == -1) {
            return false;
        }
        items[indexOf(id)] = item;
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int length = size - index;
        if (index == -1) {
            return false;
        }
        System.arraycopy(items, start, items, index, length);
        items[size - 1] = null;
        size--;
        return true;
    }
}