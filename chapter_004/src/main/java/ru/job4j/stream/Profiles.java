package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.27
 *  @author Chashkov Alexander
 */
public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
