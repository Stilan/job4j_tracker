package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class TrackerPrivateStaticFinalClassTest {

    @Test
    public void PrivateStaticFinalClassTest(){
        TrackerPrivateStaticFinalClass trackerPrivateStaticFinalClass1 = TrackerPrivateStaticFinalClass.getInstance();
        TrackerPrivateStaticFinalClass trackerPrivateStaticFinalClass2 = TrackerPrivateStaticFinalClass.getInstance();
        assertSame(trackerPrivateStaticFinalClass1,trackerPrivateStaticFinalClass2);

    }

}