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
   size of parallel sorting and be run with different cutoff themes should be
   used. Draw a conclusion about the efficacy of the parallelizing sort.

## 1. Files:

- [par/Main.java](/src/main/java/edu/neu/coe/info6205/sort/par/Main.java)
- -[par/ParSort.java](/src/main/java/edu/neu/coe/info6205/sort/par/ParSort.java)

## 2. Evidences:
