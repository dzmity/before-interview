package by.study.rafalovich.sort;

public class SelectionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(T[] items) {
        for (int index = 0; index < items.length - 1; index++) {
            var minimalItemPositionInUnsortedArray = findMinimalItemPositionInUnsortedArray(items, index);
            if (minimalItemPositionInUnsortedArray == index) {
                continue;
            }
            swap(items, index, minimalItemPositionInUnsortedArray);
        }
    }

    private int findMinimalItemPositionInUnsortedArray(T[] items, int firstIndexOfUnsortedElement) {
        var minimalItemIndex = firstIndexOfUnsortedElement;
        var minimalItem = items[firstIndexOfUnsortedElement];
        for (int index = firstIndexOfUnsortedElement + 1; index < items.length; index++) {
            var currentItem = items[index];
            if (currentItem.compareTo(minimalItem) < 0) {
                minimalItemIndex = index;
                minimalItem = currentItem;
            }
        }
        return minimalItemIndex;
    }
}
