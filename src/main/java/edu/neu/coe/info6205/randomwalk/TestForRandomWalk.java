package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class TestForRandomWalk {

    public static double randomWalk(int m) {
        int x = 0, y = 0;
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            int direction = rand.nextInt(4);
            switch (direction) {
                case 0:
                    y += 1;
                    break;
                case 1:
                    y -= 1;
                    break;
                case 2:
                    x += 1;
                    break;
                case 3:
                    x -= 1;
                    break;
            }
        }
        double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return d;
    }

    public static void main(String[] args) {
        int m = 100;
        double d = randomWalk(m);
        System.out.println("After " + m + " steps, the man is " + d + " meters away from the lamp post.");
    }
}


