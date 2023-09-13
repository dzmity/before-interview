package by.study.rafalovich.sort;

public class InsertionSort<T extends Comparable<T>> extends BaseSort<T> {

    @Override
    public void sort(T[] items) {
        for (int index = 1; index < items.length; index++) {
            var currentItem = items[index];
            // optimization (if in the necessary position)
            var biggestItemInPreviouslySortedArray = items[index - 1];
            if (currentItem.compareTo(biggestItemInPreviouslySortedArray) >= 0) {
                continue;
            }
            var indexToInsert = findPositionToInsertInPreviouslySortedArray(items, index);
            insertInNecessaryPosition(items, indexToInsert, index);
        }
    }

    private int findPositionToInsertInPreviouslySortedArray(T[] items, int itemIndexToInsert) {
        var itemToInsert = items[itemIndexToInsert];
        // search in previously sorted array
        for (int i = 0; i < itemIndexToInsert; i++) {
            var item = items[i];
            if (itemToInsert.compareTo(item) < 0) {
                return i;
            }
        }
        throw new RuntimeException("Invalid logic for sorting");
    }

    private void insertInNecessaryPosition(T[] items, int indexToInsert, int indexFrom) {
        var itemToInsert = items[indexFrom];
        var previousItemInNecessaryPosition = items[indexToInsert];
        items[indexToInsert] = itemToInsert;

        for (int index = indexFrom - 1; index > indexToInsert; index --) {
            items[index + 1] = items[index];
        }
        items[indexToInsert + 1] = previousItemInNecessaryPosition;
    }
}
