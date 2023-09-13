package by.study.rafalovich.sorted;

import by.study.rafalovich.Search;

public class InterpolationSearch extends Search {

    @Override
    public int findFirstIndex(int[] mass, int elementToSearch) {
        int startIndex = FIRST_ELEMENT_INDEX;
        int lastIndex = (mass.length - 1);

        while ((startIndex <= lastIndex)
                && elementToSearchInRange(mass, elementToSearch, startIndex, lastIndex)) {

            int position = evaluatePosition(mass, elementToSearch, startIndex, lastIndex);
            int potentialCandidate = mass[position];

            if (potentialCandidate == elementToSearch) {
                return position;
            }

            if (elementToSearch >= potentialCandidate) {
                startIndex = position + 1;
            } else {
                lastIndex = position - 1;
            }
        }
        return NOT_FOUND_INDEX;
    }

    private boolean elementToSearchInRange(int[] mass, int elementToSearch, int startIndex, int lastIndex) {
        return (elementToSearch >= mass[startIndex]) && (elementToSearch <= mass[lastIndex]);
    }

    // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
    private int evaluatePosition(int[] mass, int elementToSearch, int startIndex, int lastIndex) {
        return startIndex + (((lastIndex - startIndex) / (mass[lastIndex] - mass[startIndex])) *
                (elementToSearch - mass[startIndex]));
    }
}
