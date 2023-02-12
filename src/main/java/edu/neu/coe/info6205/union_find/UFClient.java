package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
    public static void main(String[] args) {
        /*Following is the code that take command line value as N*/
        /*
            int n = Integer.parseInt(args[0]);
            int connections = count(n);
            System.out.println("The connections are: " + connections);
         * */

//         Observe the relationship between N and connections:
        int n = 80000;
        for (int i = 1; i < n; i *= 4) {
            System.out.println("n:" + i + "; connections: " + count(i));
        }


        //Observe the relation between N and the number of the random number pairs:
        int n2 = 50000;
        int trails = 100;
        for (int i = 100; i < n2; i *= 2) {
            int mean = getMean(i, trails);
            System.out.println("n: " + i + "; m: " + mean + "; 1/2NlogN: " + (int) (0.5 * i * Math.log(i)));

        }

    }

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int connections = 0;
        while (uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);

            if (!uf.isConnected(p, q)) {
                uf.connect(p, q);
                connections++;
            }
        }

        return connections;
    }

    public static int countM(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int pair = 0;
        while (uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            pair++;
            if (!uf.isConnected(p, q)) {
                uf.connect(p, q);
            }
        }

        return pair;
    }

    private static int getMean(int n, int trails) {
        int sum = 0;
        for (int i = 0; i < trails; i++) {
            sum += countM(n);
        }
        return sum / trails;
    }
}

