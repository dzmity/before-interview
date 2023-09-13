package by.study.rafalovich.unsorted;

import by.study.rafalovich.Search;

public class LinearSearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {
        return findIndex(mass, elementToSearch, FIRST_ELEMENT_INDEX, mass.length - 1);
    }

    public static int findIndex(int[] mass, int elementToSearch, int startIndex, int endIndex) {
        for (int index = startIndex; index <= endIndex; index++) {
            if (mass[index] == elementToSearch) {
                return index;
            }
        }
        return NOT_FOUND_INDEX;
    }
}
