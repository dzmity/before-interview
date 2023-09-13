package by.study.rafalovich.sorted;

import by.study.rafalovich.Search;

public class IterativeBinarySearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {
        int firstIndex = FIRST_ELEMENT_INDEX;
        int lastIndex = mass.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (mass[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            if (elementToSearch < mass[middleIndex]) {
                lastIndex = middleIndex - 1;
            } else {
                firstIndex = middleIndex + 1;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
