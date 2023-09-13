package by.study.rafalovich.sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(T[] items) {
        if (items.length <= 1) {
            return;
        }
        var firstIndexOfRightArray = items.length / 2;
        var leftArray = Arrays.copyOfRange(items, 0, firstIndexOfRightArray);
        var rightArray= Arrays.copyOfRange(items, firstIndexOfRightArray, items.length);
        sort(leftArray);
        sort(rightArray);
        merge(items, leftArray, rightArray);
    }

    private void merge(T[] items, T[] leftItems, T[] rightItems) {
        var leftArrayIndex = 0;
        var rightArrayIndex = 0;
        for (int index = 0; index < items.length; index++) {

            if (rightArrayIndex == rightItems.length){
                items[index] = leftItems[leftArrayIndex];
                leftArrayIndex++;
                continue;
            }
            
            if (leftArrayIndex == leftItems.length) {
                items[index] = rightItems[rightArrayIndex];
                rightArrayIndex++;
                continue;
            }
            var leftArrayMinimalItem = leftItems[leftArrayIndex];
            var rightArrayMinimalItem = rightItems[rightArrayIndex];
            if (leftArrayMinimalItem.compareTo(rightArrayMinimalItem) <= 0) {
                items[index] = leftArrayMinimalItem;
                leftArrayIndex++;
            } else {
                items[index] = rightItems[rightArrayIndex];
                rightArrayIndex++;
            }
        }
    }
}
