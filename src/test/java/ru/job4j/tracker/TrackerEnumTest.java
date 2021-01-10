package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class TrackerEnumTest  {

    @Test
    public void enumTest() {
        TrackerEnum trackerEnum1 = TrackerEnum.INSTANCE;
        TrackerEnum trackerEnum2 = TrackerEnum.INSTANCE;
        assertSame(trackerEnum1, trackerEnum2);
    }

}