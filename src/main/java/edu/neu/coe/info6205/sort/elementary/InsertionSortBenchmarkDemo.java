package edu.neu.coe.info6205.sort.elementary;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmarkDemo {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 3, 2, 1};
        Supplier<Integer[]> supplier = () -> Arrays.copyOf(arr, arr.length);


    }

    private static void shuffleArray(Integer[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {

            int index = random.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;

        }
    }


    private static void reverseArray(Integer[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
