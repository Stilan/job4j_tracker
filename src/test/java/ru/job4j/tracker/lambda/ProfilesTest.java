package ru.job4j.tracker.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest  {
       List<Profile> profileList = new ArrayList<>();

    @Before
    public void setUp() {
        profileList.add(new Profile(new Address("Москва", "Ленина", 12, 43)));
        profileList.add(new Profile(new Address("Н-Новгород", "Гогаля", 14, 4)));
        profileList.add(new Profile(new Address("Мурманск", "Гогаля", 12, 5)));
        profileList.add(new Profile(new Address("Екатеренбург", "Ленина", 16, 3)));
        profileList.add(new Profile(new Address("Челябенск", "Гогаля", 43, 8)));
    }

    @Test
    public void whenCollectClassA() {
        Profiles profiles = new Profiles();
        List<Address> addressList = profiles.collect(profileList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Москва", "Ленина", 12, 43));
        expected.add(new Address("Н-Новгород", "Гогаля", 14, 4));
        expected.add(new Address("Мурманск", "Гогаля", 12, 5));
        expected.add(new Address("Екатеренбург", "Ленина", 16, 3));
        expected.add(new Address("Челябенск", "Гогаля", 43, 8));
        assertThat(addressList, is(expected));

    }
}