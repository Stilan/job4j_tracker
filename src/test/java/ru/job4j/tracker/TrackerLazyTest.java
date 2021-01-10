package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class TrackerLazyTest  {
   @Test
    public void lazyTest() {
       TrackerLazy trackerLazy1 = TrackerLazy.getInstance();
       TrackerLazy trackerLazy2 = TrackerLazy.getInstance();
       assertSame(trackerLazy1, trackerLazy2);

   }

}