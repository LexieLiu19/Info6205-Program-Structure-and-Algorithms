# Assignment 4 WQUPC Report

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NUID：002761429
- Date: Feb.11,2023.

## 0. The files needed or I modified in assignment 3:

- [UF_HWQUPC.java](/src/main/java/edu/neu/coe/info6205/union_find/UF_HWQUPC.java)
    - Added the implementation of `find``mergeComponents``doPathCompression`
      method:


- [UFClient.java](/src/main/java/edu/neu/coe/info6205/util/Timer.java)
    - Added the Implementation of `repeat`,`toMillisecs` `getClock` methods.
- [InsertionSortBenchmarkDemo.java](/src/main/java/edu/neu/coe/info6205/union_find/UFClient.java)
    - Added this file to implement UF client. Use the `count() ` method to
      observe the number of connections.

## 1. Unit Tests ScreenShots:

### 1.1 Test:

![Unit Tests Passing Screenshot](/src/main/resources/screen_shots/UF_Unit_Tests.png)

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