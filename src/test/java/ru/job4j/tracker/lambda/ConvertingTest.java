package ru.job4j.tracker.lambda;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.tracker.lambda.Converting.matricesToList;

public class ConvertingTest {
     @Test
    public void testMatricesToList() {
         Integer[][] integers = new Integer[2][2];
         for (int i = 0; i < 2; i++) {
             for (int j = 0; j < 2; j++) {
                 Integer integer = j + i;
                 integers[i][j] = integer;
             }
         }
         List<Integer> rsl = matricesToList(integers);
         List<Integer> expected = new ArrayList<>();
         expected.add(0);
         expected.add(1);
         expected.add(1);
         expected.add(2);
         assertThat(rsl, is(expected));
    }
}