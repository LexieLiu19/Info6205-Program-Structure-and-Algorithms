# Assignment 6 Hits as time predictor

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NU ID：002761429
- Date: Mar.12,2023.

## 0. Tasks:

In this assignment, the task is to determine--for sorting algorithms--what is
the best predictor of total execution time: comparisons, swaps/copies, hits (
array accesses), or something else.

I need to run the benchmarks for merge sort, (dual-pivot) quick sort, and heap
sort and sort randomly generated arrays of between 10,000 and 256,000 elements (
doubling the size each time).

## 1. Files:

1.1 [MergeSort.java](/src/main/java/edu/neu/coe/info6205/sort/linearithmic/MergeSort.java)

1.2 [MergeSort Runtime Test Demo](/src/test/java/edu/neu/coe/info6205/sort/linearithmic/MergeSortTestDemo.java)

1.3 [QuickSort Runtime Test Demo](/src/test/java/edu/neu/coe/info6205/sort/linearithmic/QuickSortTestDemo.java)

1.2 [HeapSort Runtime Test Demo](/src/test/java/edu/neu/coe/info6205/sort/linearithmic/HeapSortTestDemo.java)

## 2. Conclusions:

### 2.1 MergeSort:

The overall runtime of MergeSort is O(N*logN) in the worst case. In terms of
predicting the runtime of MergeSort, the number of comparisons and the number of
swaps/copies are typically better predictors than the number of hits (array
accesses).

### 2.2 Heapsort:

Heap sort's main predictors of total execution time are the number of
comparisons and swaps. The number of comparisons in heap sort is O(nlogn) and is
determined by the number of elements in the input array. The number of swaps in
heap sort is also proportional to nlogn. Although the number of hits can affect
performance, it is typically less important than the number of comparisons and
swaps. Heap sort has good cache locality and accesses elements in a contiguous
manner, which can help reduce cache misses and improve performance. Overall,
heap sort is an efficient algorithm for large input sizes due to its
proportional number of comparisons and swaps.

### 2.3 QuickSort:

For quicksort, the number of comparisons tends to be the most important
predictor of total execution time, followed by the number of swaps/copies. This
is because the number of comparisons determines the number of recursive calls
made by the algorithm, which can have a significant impact on overall
performance. Swaps and copies can also affect performance, but tend to be less
important than comparisons.

## 3. Test Cases Passing ScreenShots:

MergeSortTest:

![MergeSort Test](/src/main/resources/screen_shots/MergeSortTestCase.png)

## 4. Data and Graphs

- MergeSort:

![MergeSort Data](/src/main/resources/screen_shots/Mergesortdata.png)
![MergeSort graph](/src/main/resources/screen_shots/mergeSortGraph.png)

- QuickSort:
  ![QuickSort Data](/src/main/resources/screen_shots/quicksortdata.png)
  ![QuickSort graph](/src/main/resources/screen_shots/quicksortgraph.png)

- HeapSort:
  ![HeapSort data](/src/main/resources/screen_shots/heapSortdata.png)
  ![HeapSort graph](/src/main/resources/screen_shots/heapSortGraph.png)