package by.study.rafalovich;

import by.study.rafalovich.sorted.JumpSearch;

public class Runner {

    private static final int[] MASS = {1, 22, 27, 47, 57, 67, 89, 91, 95, 99};

    public static void main(String[] args) {
        Search search = new JumpSearch();
        var index = search.findFirstIndex(MASS, 99);
        System.out.println(index);
    }
}
