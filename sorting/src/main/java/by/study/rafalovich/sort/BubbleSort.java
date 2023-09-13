package by.study.rafalovich.sort;

public class BubbleSort<T extends Comparable<T>> extends BaseSort<T> {


    @Override
    public void sort(T[] items) {
        for (int j = 0; j < items.length - 1; j++) {
            for (int i = 0; i < items.length - 1 - j; i++) {
                var currentItem = items[i];
                var nextItem = items[i + 1];
                if (currentItem.compareTo(nextItem) > 0) {
                    swap(items, i, i + 1);
                }
            }
        }
    }
}
