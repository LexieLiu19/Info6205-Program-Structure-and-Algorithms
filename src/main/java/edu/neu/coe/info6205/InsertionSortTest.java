package edu.neu.coe.info6205;

public class InsertionSortTest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 6, 7, 0};

        sort(nums, 0, 5);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sort(int arr[], int from, int to) {
        int n = arr.length;
        for (int i = from; i <= to; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
