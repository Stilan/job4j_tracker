package ru.job4j.tracker.lambda;

public class Info {
    int added;
    int changed;
    int deleted;

    @Override
    public String toString() {
        return "Info{" +
                "added=" + added +
                ", changed=" + changed +
                ", deleted=" + deleted +
                '}';
    }
}
