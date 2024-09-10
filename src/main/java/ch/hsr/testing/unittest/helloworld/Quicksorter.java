package ch.hsr.testing.unittest.helloworld;

import java.util.ArrayList;
import java.util.List;

// https://gist.github.com/ntruessel/bf117eb7679487d87196aeba8077d27f
public class Quicksorter {
    public <T extends Comparable<T>> List<T> quicksort(List<T> list) {
        if (list.size() > 1) {
            var pivot = list.get(list.size() - 1);

            var left = list.stream().filter(it -> it.compareTo(pivot) < 0).toList();
            var middle = list.stream().filter(it -> it.compareTo(pivot) == 0).toList();
            var right = list.stream().filter(it -> it.compareTo(pivot) > 0).toList();

            var result = new ArrayList<>(quicksort(left));
            result.addAll(middle);
            result.addAll(quicksort(right));

            return result;
        } else {
            return list;
        }
    }
}
