# Program Structure & Algorithm Spring 2023, Section 3

## Assignment2: 3Sum Problem

Student Name: Xu Liu (liu.xu1@northeastern.edu)

NUID: 002761429

Date: Jan.28, 2023.

### 0. The files needed or I modified in assignment 2:

1) [ThreeSumCubic.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumCubic.java)

2)[ThreeSumQuadratic.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumQuadratic.java)

3) [ThreeSumQuadraticWithCalipers.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumQuadraticWithCalipers.java)

4)[]()

### 1. Unit Tests ScreenShots:

1.1 Unit tests codes unchanged evidence:
![Unit tests codes unchanged evidence](/src/main/java/edu/neu/coe/info6205/threesum/evidences/Unit-tests-codes-unchanged.png)

1.2 Unit tests passing evidence:
![Unit tests passing evidence](/src/main/java/edu/neu/coe/info6205/threesum/evidences/unit_tests_passing.png)

### 2. Timing observations:

### 3. Why the quadratic method(s) work:

The quadratic method works with the sorted array in non-descending order. First
we iterate the array from index `0` to index `length-1`. Inside the loop, we use
two pointers, one to the current index + 1(`i+1`) and the other to the of the
last element of the array(`length-1`). These two pointers iterate through the
remaining elements of the array, checking the sum of the current element and the
pair of elements to which the two pointers
point `array[i]+ array[pointer1] + array[pointer2]`. If the sum is 0, we add the
three num the triple. Otherwise, we move the pointers accordingly: sum > 0, the
start pointer + 1; sum < 0, the end pointer - 1;

This method uses the ordered nature of the input array to avoid unnecessary
comparisons. Since there are two nested loops, the total time complexity is O(
n^2), which is much better than the cubic method.