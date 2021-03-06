package ru.job4j.tracker.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress).sorted(new AddressComparator()).distinct().
                collect(Collectors.toList());
    }

}
