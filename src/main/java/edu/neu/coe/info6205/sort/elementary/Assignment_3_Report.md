# Assignment 3 Benchmark Report

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NUID：002761429
- Date: Feb.04,2023.

## 0. The files needed or I modified in assignment 3:

- [InsertionSort.java](/src/main/java/edu/neu/coe/info6205/sort/elementary/InsertionSort.java)
    - Added the implementation of `sort` method.
- [Timer.java](/src/main/java/edu/neu/coe/info6205/util/Timer.java)
    - Added the Implementation of `repeat`,`toMillisecs` `getClock` methods.
- [InsertionSortBenchmarkDemo.java](/src/main/java/edu/neu/coe/info6205/sort/elementary/InsertionSortBenchmarkDemo.java)
    - Added this file to test the runing time of insertion sort for 4 different
      sorted types arrays.
  
## 1. Unit Tests ScreenShots:

### 1.1 TimerTest:

![Timer Unit Tests Passing Screenshot](/src/main/resources/screen_shots/TimerTests.png)

### 1.2 InsertionSort Unit Tests:

![InsertionSort Unit Tests Passing Screenshot](/src/main/resources/screen_shots/InertionSortTests.png)

## 2. Timing observations:

![Timing Observations On 4 Types Arrays](/src/main/resources/screen_shots/runningtime_of_arrays.png)

## 3. Conclusion:

From the running time observations, we can draw a conclusion: generally,
Insertion sort has the best performance when the array is already sorted. The
time complexity is O(n). When the array is randomly ordered, namely, un-sorted,
the average-time complexity is O(n^2). When the array is reversely sorted, the
running time is even longer. The worst-case of time complexity is O(n^2). When
the array is half-sorted, the time complexity can be anywhere between O(n) and
O(n^2), depending on the distribution of the sorted and unsorted elements.