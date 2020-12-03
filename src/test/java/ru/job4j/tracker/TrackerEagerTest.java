package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class TrackerEagerTest  {

      @Test
    public void EagerTest(){
         TrackerEager trackerEager1 = TrackerEager.INSTANCE;
         TrackerEager trackerEager2 = TrackerEager.INSTANCE;
         assertSame(trackerEager1,trackerEager2);
      }
}