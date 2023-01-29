package edu.neu.coe.info6205.threesum;

import edu.neu.coe.info6205.util.Stopwatch;

import java.util.function.Supplier;

public class RunningTimeTestDemo {


    public static void main(String[] args) {


        for (int i = 10; i <= 10000; i = i * 2) {
            Source source = new Source(i, 10 * i);
            Supplier<int[]> supplier = source.intsSupplier(2);
            int[] randomArray = supplier.get();

            System.out.println("Random Array Length = " + randomArray.length);
            ThreeSumQuadratic quadratic = new ThreeSumQuadratic(randomArray);
            ThreeSumCubic cubic = new ThreeSumCubic(randomArray);
            ThreeSumQuadrithmic quadrithmic = new ThreeSumQuadrithmic(randomArray);
            ThreeSumQuadraticWithCalipers calipers = new ThreeSumQuadraticWithCalipers(randomArray);


            try (Stopwatch sw = new Stopwatch()) {
                cubic.getTriples();
                long elapsed = sw.lap();
                System.out.println("Cubic method Elapsed time: " + elapsed + " milliseconds");
            }

            try (Stopwatch sw = new Stopwatch()) {
                quadratic.getTriples();
                long elapsed = sw.lap();
                System.out.println("Quadratic Method Elapsed time: " + elapsed + " milliseconds");
            }


            try (Stopwatch sw = new Stopwatch()) {
                quadrithmic.getTriples();
                long elapsed = sw.lap();
                System.out.println("Quadrithmic Method Elapsed time: " + elapsed + " milliseconds");
            }


            try (Stopwatch sw = new Stopwatch()) {
                calipers.getTriples();
                long elapsed = sw.lap();
                System.out.println("Calipers Method Elapsed time: " + elapsed + " milliseconds");
            }

        }


    }
}
