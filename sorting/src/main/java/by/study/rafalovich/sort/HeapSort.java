package by.study.rafalovich.sort;

public class HeapSort<T extends Comparable<T>> extends BaseSort<T> {

    private static final int ROOT_INDEX = 0;

    @Override
    public void sort(T[] items) {
        heapSort(items, items.length - 1);
    }

    private void heapSort(T[] items, int endIndex) {
        if (endIndex != ROOT_INDEX) {
            createMaxHeap(items, endIndex);
            swap(items, ROOT_INDEX, endIndex);
            heapSort(items, endIndex - 1);
        }
    }

    private void createMaxHeap(T[] items, int endIndex) {
        for (int index = ROOT_INDEX; index <= endIndex - 1; ) {

            var currentNode = items[index];

            var leftNodeIndex = findLeftChildNodeIndex(index);
            if (leftNodeIndex <= endIndex) {
                var leftNode = items[leftNodeIndex];
                if (currentNode.compareTo(leftNode) < 0) {
                    swap(items, index, leftNodeIndex);
                    index = findParentNodeIndexFromLeft(index);
                    continue;
                }
            }

            var rightNodeIndex = findRightChildNodeIndex(index);
            if (rightNodeIndex <= endIndex) {
                var rightNode = items[rightNodeIndex];
                if (currentNode.compareTo(rightNode) < 0) {
                    swap(items, index, rightNodeIndex);
                    index = findParentNodeIndexFromRight(index);
                    continue;
                }
            }
            index++;
        }
    }

    private int findLeftChildNodeIndex(int index) {
        return 2 * index + 1;
    }

    private int findParentNodeIndexFromLeft(int index) {
        return index == ROOT_INDEX ? ROOT_INDEX : (index - 1) / 2;
    }

    private int findRightChildNodeIndex(int index) {
        return 2 * index + 2;
    }

    private int findParentNodeIndexFromRight(int index) {
        return index == ROOT_INDEX ? ROOT_INDEX : (index - 2) / 2;
    }
}
