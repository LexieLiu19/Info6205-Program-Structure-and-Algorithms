package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Timer;

import java.util.Random;

public class InsertionSortBenchmarkDemo {

    public static void main(String[] args) {

        System.out.println("Test running time for sorted array: ");
        for (int i = 1000; i <= 16000; i = i * 2) {
            InsertionSort<Integer> insertionSort = new InsertionSort<>();
            Integer[] arr = generateSortedArray(i);
            Timer timer = new Timer();
            double result = timer.repeat(100, () -> insertionSort.sort(arr));
            System.out.println("Sorted array: length = " + i + ", took an average of " + result + " milliseconds to run.");

        }

        System.out.println("Test running time for random array: ");
        for (int i = 1000; i <= 16000; i = i * 2) {
            InsertionSort<Integer> insertionSort = new InsertionSort<>();
            Integer[] arr = generateSortedArray(i);
            shuffleArray(arr);
            Timer timer = new Timer();
            double result = timer.repeat(100, () -> insertionSort.sort(arr));
            System.out.println("Random array: length = " + i + ", took an average of " + result + " milliseconds to run.");

        }
        System.out.println("Test running time for reversed sorted array: ");
        for (int i = 1000; i <= 16000; i = i * 2) {
            InsertionSort<Integer> insertionSort = new InsertionSort<>();
            Integer[] arr = generateSortedArray(i);
            reverseArray(arr);
            Timer timer = new Timer();
            double result = timer.repeat(100, () -> insertionSort.sort(arr));
            System.out.println("Random array: length = " + i + ", took an average of " + result + " milliseconds to run.");

        }
        System.out.println("Test running time for half sorted array: ");
        for (int i = 1000; i <= 16000; i = i * 2) {
            InsertionSort<Integer> insertionSort = new InsertionSort<>();
            Integer[] arr = generateSortedArray(i);
            halfSortedArray(arr);
            Timer timer = new Timer();
            double result = timer.repeat(100, () -> insertionSort.sort(arr));
            System.out.println("Random array: length = " + i + ", took an average of " + result + " milliseconds to run.");

        }


    }

    private static Integer[] generateSortedArray(int N) {
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        return arr;
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

    private static void halfSortedArray(Integer[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        for (int i = array.length / 2; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }
}
