package by.study.rafalovich.sorted;

import java.util.Arrays;

import by.study.rafalovich.Search;

public class ExponentialSearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {

        int minElement = mass[FIRST_ELEMENT_INDEX];
        if (minElement == elementToSearch) {
            return FIRST_ELEMENT_INDEX;
        }

        int lastElementIndex = mass.length - 1;
        int maxElement = mass[lastElementIndex];
        if (maxElement == elementToSearch) {
            return lastElementIndex;
        }

        int range = 1;
        while (range < mass.length && elementToSearch >= mass[range]) {
            range = range * 2;
        }

        return RecursiveBinarySearch.findIndex(mass, elementToSearch, range / 2, Math.min(range, mass.length));
    }
}
