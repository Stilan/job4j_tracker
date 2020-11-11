package ru.job4j.tracker;


import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;




public class StartUITest extends TestCase {

    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }


    public void testCreateItem3() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.createItem3(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }


    public void testCreateItem4() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()) // id сохраненной заявки в объект tracker.

        };

        StartUI.createItem4(new StubInput(answers), tracker);
         Item delete = tracker.findById(item.getId());
        assertThat(delete,is(nullValue(null)));
    }
}