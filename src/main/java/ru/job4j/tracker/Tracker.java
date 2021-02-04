package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;
  //  private int size = 0;

    /**
     * добавляет заявку, переданную в аргументах в массив заявок items.
     * @param item уникальный ключ в объект Item
     * @return item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> items2 = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (key.equals(item.getName())) {
                //items2[j] = item;
                items2.add(item);
               // j++;
            }
        }
       // items2 = Arrays.copyOf(items2, j);
        return items2;
    }

    /**
     * Метод indexOf объявлен как private,
     * потому что он используется только внутри системы.
     * @param id это уникальный номер заявления.
     * @return метод возвращает объект Item
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int intId = indexOf(id);
        item.setId(id);
        boolean rsl = intId != -1;
        if (rsl) {
           // items.remove(intId);
           // items.add(intId,item);
            items.set(intId, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            // System.arraycopy(items, start, items, index, items.size());
           // items.add(size-1,null);
             items.remove(index);
        //    size--;
        }
        return rsl;
    }
}