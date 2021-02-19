package ru.job4j.tracker.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest  {

     private List<Profile> profileArrayList = new ArrayList<>();

    @Before
    public void setUp() {
        profileArrayList.add(new Profile(new Address("Москва", "Ленина", 12, 43)));
        profileArrayList.add(new Profile(new Address("Н-Новгород", "Гоголя", 14, 4)));
        profileArrayList.add(new Profile(new Address("Мурманск", "Гоголя", 12, 5)));
        profileArrayList.add(new Profile(new Address("Екатеренбург", "Ленина", 16, 3)));
        profileArrayList.add(new Profile(new Address("Москва", "Гоголя", 43, 8)));
        profileArrayList.add(new Profile(new Address("Москва", "Гоголя", 43, 8)));
        profileArrayList.add(new Profile(new Address("Москва", "Гоголя", 43, 8)));
    }

    @Test
    public void profilesTest1() {
        Profiles profiles = new Profiles();
        List<Address> addressList = profiles.collect(profileArrayList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Екатеренбург", "Ленина", 16, 3));
        expected.add(new Address("Москва", "Ленина", 12, 43));
        expected.add(new Address("Москва", "Гоголя", 43, 8));
        expected.add(new Address("Мурманск", "Гоголя", 12, 5));
        expected.add(new Address("Н-Новгород", "Гоголя", 14, 4));
        assertThat(addressList, is(expected));

    }
}