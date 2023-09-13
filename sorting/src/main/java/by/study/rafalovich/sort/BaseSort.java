package by.study.rafalovich.sort;

public abstract class BaseSort<T extends Comparable<T>> {

    public abstract void sort(T[] items);

    protected void swap(T[] items, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return;
        }
        var firstItem = items[firstIndex];
        var secondItem = items[secondIndex];
        var temp = firstItem;
        items[firstIndex] = secondItem;
        items[secondIndex] = temp;
    }
}
