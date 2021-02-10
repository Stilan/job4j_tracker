package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;

public class Analize {
    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = (int) current.stream().dropWhile(previous::contains).count();
        // метод dropWhile удалит все элементы которых есть в previous а count() выдаст количество элементов в потоке;
        info.deleted = (int) previous.stream().filter(o -> !current.contains(o)).count();
        // filter возвращает поток, состоящий из элементов этого потока, которые соответствуют заданному предикату.
        // filter(o -> !current.contains(o)).count() предикат !current.contains(o) не содержет current список элемент о.previous.
        info.changed = (int) previous.stream().
                filter(current::contains).
                filter(o -> !o.getName().equals(current.get(current.indexOf(o)).getName())).
                count();
        // filter(current::contains) возвращает поток, состоящий из элементов этого потока(current::contains количество элементов в current).
        // !o.getName().equals(current.get(current.indexOf(o)).getName())). количество элементов не равных previous в current;
        return info;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        List<User> previousList = new ArrayList<>();
        userList.add(new User(1, "Вася"));
        userList.add(new User(2, "Коля"));
        userList.add(new User(3, "Толя"));
        userList.add(new User(4, "Серега"));
        userList.add(new User(5, "Юля"));
       userList.add(new User(6, "Оля"));
        previousList.add(new User(1, "Вася"));
        previousList.add(new User(2, "Коля"));
        previousList.add(new User(3, "Толя"));
        previousList.add(new User(4, "Серега"));
        previousList.add(new User(5, "Юля"));
        previousList.add(new User(6, "Оля"));
        System.out.println(diff(previousList, userList));

    }
}
