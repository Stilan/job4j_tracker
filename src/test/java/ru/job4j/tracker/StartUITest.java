package ru.job4j.tracker;


import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;




public class StartUITest  {
     @Test
    public void testCreateItem() {
        String[] answers = {"Fix PC","XXX","XXX"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
       // StartUI.(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

     @Test
    public void testCreateItem3() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
    //    StartUI.createItem3(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

      @Test
    public void testCreateItem4() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()) // id сохраненной заявки в объект tracker.
        };
     //   StartUI.createItem4(new StubInput(answers), tracker);
         Item delete = tracker.findById(item.getId());
        assertThat(delete,is(nullValue(null)));
    }
    @Test
    public void testInit() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
    //            new CreateAction(),
                //new Exit()
        };
   //     new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] { "0",String.valueOf(item.getId()),replacedName/* входные параметры для ReplaceAction */, "1"}
                );
        UserAction[] actions = {
           //     new ReplaceActon(),
               // new Exit()
        };
      //  new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()) /* входные параметры для DeleteAction */, "1"}
        );
        UserAction[] actions = {
                //new DeleteAction(),
              //  new Exit()
        };
    //    new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
    @Test
    public void whenExit() {

        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowItems(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                         "==== Show all items ===="+ System.lineSeparator() +
                        "Menu." + System.lineSeparator()+
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","s","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {

                new SearchName(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                        "=== Find items by name ====" + System.lineSeparator() +
                        "Заявки с таким именем не найдены" + System.lineSeparator() +
                        "Menu."+ System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0","1","1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new IndexSearch(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()+
                        "=== Find item by Id ====" + System.lineSeparator() +
                        "Заявка с таким id не найдена" + System.lineSeparator() +
                        "Menu."+ System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }
      @Test
      public void whenInvalidExit() {
          Output out = new StubOutput();
          Input in = new StubInput(
                  new String[]{ /* Пункты меню: неверный, верный.*/"8","0"}
          );
          Tracker tracker = new Tracker();
          UserAction[] actions = {
                  new Exit()
          };
          new StartUI(out).init(in, tracker, actions);
          assertThat(out.toString(), is(
                  String.format(
                          "Menu.%n"
                                  + "0. Exit%n"
                                  + "Wrong input, you can select: 0 .. 0%n"
                                  + "Menu.%n"
                                  + "0. Exit%n"
                  )
          ));
      }
}