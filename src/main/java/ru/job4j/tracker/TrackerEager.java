package ru.job4j.tracker;

public class TrackerEager {
    public static final TrackerEager INSTANCE = new TrackerEager();

    private TrackerEager() {
    }

    public static TrackerEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerEager tracker = TrackerEager.getInstance();
    }
}
