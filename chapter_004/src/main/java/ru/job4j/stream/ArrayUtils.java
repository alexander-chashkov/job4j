package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

/**
 *  @version 0.0.0.1
 *  @since 2019.03.08
 *  @author Chashkov Alexander
 */
public class ArrayUtils {
    public long sumSqrEvenNumber(List<Long> arr) {
        Optional<Long> result = arr.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce((x, y) -> x + y);
        return result.get();
    }

}
