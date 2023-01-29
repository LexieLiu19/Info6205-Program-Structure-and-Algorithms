# Program Structure & Algorithm Spring 2023, Section 3

## Assignment2: 3Sum Problem

Student Name: Xu Liu (liu.xu1@northeastern.edu)

NUID: 002761429

Date: Jan.28, 2023.

### 0. The files needed or I modified in assignment 2:

a. [ThreeSumCubic.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumCubic.java)

b. [ThreeSumQuadratic.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumQuadratic.java)

c. [ThreeSumQuadrithmic.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumQuadrithmic.java)

d. [ThreeSumQuadraticWithCalipers.java](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/ThreeSumQuadraticWithCalipers.java)

e. [Running Time Test Demo using class Stopwatch](https://github.com/LexieLiu19/Info6205-Program-Structure-and-Algorithms/blob/master/src/main/java/edu/neu/coe/info6205/threesum/RunningTimeTestDemo.java)

### 1. Unit Tests ScreenShots:

1.1 Unit tests codes unchanged evidence:
![Unit tests codes unchanged evidence](/src/main/java/edu/neu/coe/info6205/threesum/evidences/Unit-tests-codes-unchanged.png)

1.2 Unit tests passing evidence:
![Unit tests passing evidence](/src/main/java/edu/neu/coe/info6205/threesum/evidences/unit_tests_passing.png)

### 2. Timing observations:

2.1 Running Time Test Demo Screenshot:
![Running time test](/src/main/java/edu/neu/coe/info6205/threesum/evidences/runtime.png)
2.2 Runing time table based on test demo:
![Running time table](/src/main/java/edu/neu/coe/info6205/threesum/evidences/runtime-data.png)

2.3 Conclusion:

In conclusion, when the data sample is small, the runtime differences among
various methods are not significant. However, as the data sample becomes larger,
the runtime differences gradually increase and the ThreeSumQuadraticWithCalipers
method has the least runtime.

### 3. Why the quadratic method(s) work:

The quadratic method starts by iterating through the array and fixing an index
as the middle index of the three values.Then it iterates from the middle index
+1 and middle index -1, checking if the sum of the three values is equal to
zero. If the sum is equal to zero, it adds the triple to a list of triples.

The time complexity of this algorithm is O(N^2) as it needs to check all pairs
in the array. The first loop has a time complexity of O(N) and the second loop
has a time complexity of O(N) as well. Therefore, the total time complexity is
O(N^2)

It's important to be aware that the constructor's array must be ordered. This is
due to the algorithm's reliance on the array's order in order to effectively
solve the problem. If the array is not ordered, checking all possible
combinations of three values would result in a temporal complexity of O(N^3).
The approach can significantly minimize the amount of iterations required to
locate a solution by presuming that the array is ordered.

