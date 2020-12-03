package ru.job4j.tracker;

public class TrackerPrivateStaticFinalClass {
    private TrackerPrivateStaticFinalClass(){
    }

    public static TrackerPrivateStaticFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerPrivateStaticFinalClass INSTANCE = new TrackerPrivateStaticFinalClass();
    }

    public static void main(String[] args) {
        TrackerPrivateStaticFinalClass tracker = TrackerPrivateStaticFinalClass.getInstance();
    }
}
