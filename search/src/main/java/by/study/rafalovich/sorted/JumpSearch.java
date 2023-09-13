package by.study.rafalovich.sorted;

import by.study.rafalovich.Search;
import by.study.rafalovich.unsorted.LinearSearch;

public class JumpSearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {

        int lastElementIndex = mass.length - 1;
        int minElement = mass[FIRST_ELEMENT_INDEX];
        int maxElement = mass[lastElementIndex];
        if (elementToSearch < minElement || elementToSearch > maxElement) {
            return NOT_FOUND_INDEX;
        }

        int jumpSize = (int) Math.sqrt(mass.length);
        int jumpStartIndex = -1;
        int jumpEndIndex = jumpSize - 1;

        while (jumpEndIndex <= lastElementIndex) {

            if (elementToSearch <= mass[jumpEndIndex]) {
                return LinearSearch.findIndex(mass, elementToSearch, jumpStartIndex + 1, jumpEndIndex);
            }
            jumpStartIndex = jumpEndIndex;
            int potentialNextJumpIndex = jumpEndIndex + jumpSize;
            jumpEndIndex = Math.min(potentialNextJumpIndex, lastElementIndex);

        }
        return NOT_FOUND_INDEX;
    }
}
