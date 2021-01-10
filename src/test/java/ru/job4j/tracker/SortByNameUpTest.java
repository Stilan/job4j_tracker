package ru.job4j.tracker;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortByNameUpTest  {
      @Test
    public void testCompare() {
          SortByNameUp sortByNameUp = new SortByNameUp();
          List<Item> items = new ArrayList<>();
          Item item1 = new Item(1, "Вася");
          Item item2 = new Item(2, "Федя");
          Item item3 = new Item(3, "Коля");
          Item item4 = new Item(4, "Сергей");
          items.add(item1);
          items.add(item2);
          items.add(item3);
          items.add(item4);
          items.sort(sortByNameUp);
          List<Item> expected = new ArrayList<>();
          expected.add(item2);
          expected.add(item4);
          expected.add(item3);
          expected.add(item1);
          assertThat(items, is(expected));
    }
}