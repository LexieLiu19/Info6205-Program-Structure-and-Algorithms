package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
    public static void main(String[] args) {
        /* Following code: enter a value of n and print the value of connect all these n numbers.*/

//        System.out.println("Please enter a value: ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int connections = count(n);
//        System.out.println("The connections are: " + connections);

        // following code are for my observation of the number N and the connections:

        int n = 100000;
        for (int i = 1; i < n; i *= 5) {
            System.out.println("n:" + i + "; connects: " + count(i));
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

}
