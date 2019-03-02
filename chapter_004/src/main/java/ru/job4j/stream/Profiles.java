package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.27
 *  @author Chashkov Alexander
 */
public class Profiles {
    /**
     * @param profiles профили
     * @return адреса
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    /**
     * @param profiles профили
     * @return уникальные адреса, отсортированные по городу
     */
    List<Address> getUniqueSortedAddresses(List<Profile> profiles) {

        return profiles.stream().map(Profile::getAddress).distinct().sorted(
                (Address o1, Address o2) -> o1.getCity().compareTo(o2.getCity())
        ).collect(Collectors.toList());
    }
}
