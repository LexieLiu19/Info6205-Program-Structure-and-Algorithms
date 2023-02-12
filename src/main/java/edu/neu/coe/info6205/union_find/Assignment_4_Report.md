# Assignment 4 WQUPC Report

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NUID：002761429
- Date: Feb.11,2023.

## 0. The files needed or I modified in assignment 3:

- [UF_HWQUPC.java](/src/main/java/edu/neu/coe/info6205/union_find/UF_HWQUPC.java)
    - Added the implementation of `find``mergeComponents``doPathCompression`
      methods:
        - ```java

```
    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        if (pathCompression) {
            while (p != root) {
                int next = parent[p];
                parent[p] = root;
                p = next;
            }
        }
        return root;
    }
```

```java 
  /**
     * This implements the single-pass path-halving mechanism of path compression
     */
    private void doPathCompression(int i) {
        // FIXME update parent to value of grandparent
        int root = find(i);
        parent[i] = root;
    }
    
    
    private void mergeComponents(int i, int j) {
        //  make shorter root point to taller one
        int root1 = i;
        int root2 = j;
        if (height[root1] < height[root2]) {
            parent[root1] = root2;
        } else if (height[root1] > height[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            height[root1]++;
        }
        count--;

    }
```

- [UFClient.java](/src/main/java/edu/neu/coe/info6205/util/Timer.java)
    - Added the Implementation of `repeat`,`toMillisecs` `getClock` methods.
- [InsertionSortBenchmarkDemo.java](/src/main/java/edu/neu/coe/info6205/union_find/UFClient.java)
    - Added this file to implement UF client. Use the `count() ` method to
      observe the number of connections.

## 1. Unit Tests ScreenShots:

![Unit Tests Passing Screenshot](/src/main/resources/screen_shots/UF_Unit_Tests.png)

## 2. UFClient observations:

### 2.1 The relationship between N and connections:

![The relationship between N and connections]()

## 3. Conclusion:

