package ch.hsr.testing.unittest.helloworld;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

// https://gist.github.com/thomasbriner/d3ea976ac116993719da6a6e63ebe8c2
public class Quicksorter {
    public <T extends Comparable<T>> List<T> quicksort(List<T> list) {
        if (list.size() > 1) {
            var pivot = list.get(list.size() - 1);

            var left = list.stream().filter(it -> it.compareTo(pivot) < 0).collect(toList());
            var middle = list.stream().filter(it -> it.compareTo(pivot) == 0).collect(toList());
            var right = list.stream().filter(it -> it.compareTo(pivot) > 0).collect(toList());

            var result = new ArrayList<>(quicksort(left));
            result.addAll(middle);
            result.addAll(quicksort(right));

            return result;
        } else {
            return list;
        }
    }
}
