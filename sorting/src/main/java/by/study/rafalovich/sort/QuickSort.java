package by.study.rafalovich.sort;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(T[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private void quickSort(T[] items, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        var pivotIndex = findRandomPivotIndex(startIndex, endIndex);
        var indexOfItemInCorrectPosition = putPivotInCorrectPosition(items, startIndex, endIndex, pivotIndex);
        quickSort(items, startIndex, indexOfItemInCorrectPosition - 1);
        quickSort(items, indexOfItemInCorrectPosition + 1, endIndex);
    }

    private int findRandomPivotIndex(int startIndex, int endIndex) {
        return new Random().nextInt(endIndex - startIndex + 1) + startIndex;
    }

    private int putPivotInCorrectPosition(T[] items, int startIndex, int endIndex, int pivotIndex) {
        var pivotItem = items[pivotIndex];

        var lastIndexOfItemLessThanPivotItem = startIndex;
        swap(items, pivotIndex, endIndex);
        for (int index = startIndex; index < endIndex; index++) {
            var currentItem = items[index];
            if (currentItem.compareTo(pivotItem) < 0) {
                swap(items, lastIndexOfItemLessThanPivotItem, index);
                lastIndexOfItemLessThanPivotItem++;
            }
        }
        swap(items, lastIndexOfItemLessThanPivotItem, endIndex);
        return lastIndexOfItemLessThanPivotItem;
    }
}
