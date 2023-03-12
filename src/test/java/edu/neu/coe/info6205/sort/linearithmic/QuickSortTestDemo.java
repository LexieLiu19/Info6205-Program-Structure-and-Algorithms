package edu.neu.coe.info6205.sort.linearithmic;

import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.HelperFactory;
import edu.neu.coe.info6205.sort.InstrumentedHelper;
import edu.neu.coe.info6205.util.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class QuickSortTestDemo {
    private final static int MIN = 10000;
    private final static int N = 5;

    private final static int MAX = 256000;


    public static void main(String[] args) throws IOException {
        quickSortTest();
    }

    public static void quickSortTest() throws IOException {
        for (int size = MIN; size <= MAX; size *= 2) {
            //generate random arrays
            Integer[] input = new Integer[size];
            Random rd = new Random();
            for (int i = 0; i < size; i++) {
                input[i] = rd.nextInt();
            }
            // without instrumenting
            final Config c1 = Config.setupConfig("false", "0", "0", "10", "");
            final Helper<Integer> helper0 = HelperFactory.create("quick sort without Instrumenting", size, c1);
            QuickSort_DualPivot<Integer> s1 = new QuickSort_DualPivot<>(helper0);
            Consumer<Integer[]> fRun0 = s1::sort;
            UnaryOperator<Integer[]> fPre0 = b -> Arrays.copyOf(b, b.length);
            Benchmark<Integer[]> benchmark_timer_random0 = new Benchmark_Timer<>("quick sort, size = " + size, fPre0, fRun0);
            double avg_time = benchmark_timer_random0.run(input, N);
            System.out.println("Timing without instrumenting: " + avg_time);

            // with instrumenting
            final Config c2 = Config.setupConfig("true", "0", "0", "40", "");
            final Helper<Integer> helper = HelperFactory.create("quick sort", size, c2);
            QuickSort_DualPivot<Integer> s2 = new QuickSort_DualPivot<>(helper);
            Consumer<Integer[]> fRun = s2::sort;
            UnaryOperator<Integer[]> fPre = b -> {
                helper.preProcess(b);
                return Arrays.copyOf(b, b.length);
            };
            Consumer<Integer[]> fPost = b -> {
                Arrays.sort(b);
                helper.postProcess(b);
            };


            Benchmark<Integer[]> benchmark_timer_random = new Benchmark_Timer<>("quick sort, size = " + size, fPre, fRun, fPost);
            double avg_time2 = benchmark_timer_random.run(input, N);
            System.out.println("Timing with instrumenting: " + avg_time2);
            final PrivateMethodTester privateMethodTester = new PrivateMethodTester(helper);
            final StatPack statPack = (StatPack) privateMethodTester.invokePrivate("getStatPack");

            System.out.println("COMPARES:" + (int) statPack.getStatistics(InstrumentedHelper.COMPARES).mean());
            System.out.println("SWAPS:" + (int) statPack.getStatistics(InstrumentedHelper.SWAPS).mean());
            System.out.println("HITS:" + (int) statPack.getStatistics(InstrumentedHelper.HITS).mean());
            System.out.println("COPIES:" + (int) statPack.getStatistics(InstrumentedHelper.COPIES).mean());
            System.out.println("--------------------------------------------------------");

        }
    }

}
