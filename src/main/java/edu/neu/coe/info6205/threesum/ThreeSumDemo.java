package edu.neu.coe.info6205.threesum;

public class ThreeSumDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 6, 4, 6};
        ThreeSumQuadraticWithCalipers tsc = new ThreeSumQuadraticWithCalipers(nums);
        Triple[] res = tsc.getTriples();

        for (Triple t : res) {
            System.out.println(t);
        }
    }
}
