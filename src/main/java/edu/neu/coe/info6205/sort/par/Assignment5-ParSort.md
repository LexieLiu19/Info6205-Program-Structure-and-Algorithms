# Assignment 5 ParSort Report

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NU ID：002761429
- Date: Feb.18,2023.

## 0. Tasks:

The main task of assignment 5 is to implement a parallel sorting algorithm. The
algorithm sorts each partition of the input array in parallel.

1. We need to conduct experiment and find a goof value for the `curoff` that
   balances the overhead of parallelism and the performance gains of
   parallelism. The `cutoff` value is initially set to 1000, but it can be
   updated based one the first argument in the command line when running.
2. The results of the experiments should involve sorting arrays of sufficient
   size of parallel sorting and be run with different cutoffs and different
   threads should be used. Draw a conclusion about the efficacy of the
   parallelizing sort.

## 1. Files:

- [par/Main.java](/src/main/java/edu/neu/coe/info6205/sort/par/Main.java)
- [par/ParSort.java](/src/main/java/edu/neu/coe/info6205/sort/par/ParSort.java)
- [Performance Observations](/src/main/resources/Performance_Par_Sort.xlsx)

## 2. Evidences:

In testcases, I tried 1, 2, 4, 8 threads respectively, and run different number
of cutoffs(cutoff value/array size), the results show in
the [Performance Observations](/src/main/resources/Performance_Par_Sort.xlsx)
table. And the graph is below:

![Different performances in different numbers of threads and Cutoffs](/src/main/resources/screen_shots/performance.png)

## 3. Conclusion:

In my case, the efficiency of the parallel sorting algorithm depends on several
factors:

- The size of the input array: If the array size is small, the overhead of
  parallelization may outweigh the benefits. If the array is large, the
  parallelization can significantly improve the sorting time.(During the for
  loop, the sizes of the array are changing.)

- **The number of available threads**: the more threads available, the more
  partition can be processed. However, if there's too many threads, the overhead
  of thread management can slow down the algorithm.

- **The `cutoff` value**: the `cutoff` value determines the minimum sizes of
  sub-arrays that will be sorted in parallel. If the `cutoff` is too small,
  there will be too many small sub-arrays to be sorted, which will slow down the
  algorithm. If the `cutoff` value is too large, there'll be too much work to be
  done in a single thread, which can also negatively impact the performance of
  the algorithm.
