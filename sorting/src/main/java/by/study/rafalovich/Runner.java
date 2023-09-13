package by.study.rafalovich;

import java.util.Arrays;

import by.study.rafalovich.sort.BaseSort;
import by.study.rafalovich.sort.HeapSort;

public class Runner {

    private static Integer[] items = {5, 4, 3, 10, 17, 1, 2, 9, 4, 0, 3, 0, 12, 6};

    public static void main(String[] args) {
//        BaseSort<Integer> sort = new BubbleSort<>();
//        BaseSort<Integer> sort = new InsertionSort<>();
//        BaseSort<Integer> sort = new SelectionSort<>();
//        BaseSort<Integer> sort = new MergeSort<>();
//        BaseSort<Integer> sort = new QuickSort<>();
        BaseSort<Integer> sort = new HeapSort<>();

        sort.sort(items);
        System.out.println(Arrays.toString(items));

    }
}
