package by.study.rafalovich.sorted;

import by.study.rafalovich.Search;

public class RecursiveBinarySearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {
        return findIndex(mass, elementToSearch, FIRST_ELEMENT_INDEX, mass.length - 1);
    }

    public static int findIndex(int[] mass, int elementToSearch, int firstIndex, int lastIndex) {

        int middleIndex = (firstIndex + lastIndex ) / 2;
        if (mass[middleIndex] == elementToSearch) {
            return middleIndex;
        }
        if (elementToSearch < mass[middleIndex]) {
            findIndex(mass, elementToSearch, firstIndex, middleIndex - 1);
        } else {
            findIndex(mass, elementToSearch, middleIndex + 1, lastIndex);
        }

        return NOT_FOUND_INDEX;
    }
}
