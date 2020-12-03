package ru.job4j.tracker;

public class TrackerLazy {
    private static TrackerLazy instance;

    private TrackerLazy(){
    }

    private static TrackerLazy getInstance(){
        if (instance == null){
            instance = new TrackerLazy();
        }
        return instance;
    }

    public Item add(Item model){
        return model;
    }
}
