package ru.job4j.tracker.lambda;

public class Info {
    private int added;
    private   int changed;
    private   int deleted;

    public int getAdded() {
        return added;
    }

    public int getChanged() {
        return changed;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Info{"
                + "added=" + added
                + ", changed=" + changed
                + ", deleted=" + deleted
                + '}';
    }
}
