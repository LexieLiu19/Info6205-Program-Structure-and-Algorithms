# Assignment 4 WQUPC Report

- Student Name: Xu Liu
- Email: liu.xu1@northeastern.edu
- NUID：002761429
- Date: Feb.11,2023.


## 0. Tasks:

#### 1. Implement height-weighted Quick Union with Path Compression and pass the unit tests;
#### 2. Build UFClient: include a  `count` method to count the connections and `main` method to run tests.
#### 3. Observe and draw conclusions about the relationships between n and connections, n and the number of random number pairs.

## 1. Files:

###  The files I modified and added in assignment 4:

- [UF_HWQUPC.java](/src/main/java/edu/neu/coe/info6205/union_find/UF_HWQUPC.java)
    - Added the implementation of `find`, `mergeComponents`, `doPathCompression`
      methods:
```
    /**
     * Returns the component identifier for the component containing site {@code p}.
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

- [UFClient.java](/src/main/java/edu/neu/coe/info6205/union_find/UFClient.java)
    - Added the Implementation of `count`, `count2` and `main` methods.

 ```
        package edu.neu.coe.info6205.union_find;
        
        import java.util.Random;
        
        public class UFClient { public static void main(String[] args) { 
        /*Following is the code that take command line value as N*/ 
        /*
        int n = Integer.parseInt(args[0]); int connections = count(n);
        System.out.println("The connections are: " + connections);
        * */
        
        // Observe the relationship between N and connections:
        int n = 80000; for (int i = 1; i < n; i *= 4) { System.out.println("n:" + i + ";
        connections: " + count(i)); }

        //Observe the relation between N and the number of the random number pairs:
        int n2 = 50000;
        int trails = 100;
        for (int i = 100; i < n2; i *= 2) {
            int mean = getMean(i, trails);
            System.out.println("n: " + i + "; m: " + mean + "; 1/2NlogN: " + (int) (0.5 * i * Math.log(i)));

        }

    }

        public static int count(int n) {
            UF_HWQUPC uf = new UF_HWQUPC(n);
            Random random = new Random();
            int connections = 0;
            while (uf.components() > 1) {
                int p = random.nextInt(n);
                int q = random.nextInt(n);
    
                if (!uf.isConnected(p, q)) {
                    uf.connect(p, q);
                    connections++;
                }
            }
    
            return connections;
        }
    
        public static int countM(int n) {
            UF_HWQUPC uf = new UF_HWQUPC(n);
            Random random = new Random();
            int pair = 0;
            while (uf.components() > 1) {
                int p = random.nextInt(n);
                int q = random.nextInt(n);
                pair++;
                if (!uf.isConnected(p, q)) {
                    uf.connect(p, q);
                }
            }
    
            return pair;
        }
    
        private static int getMean(int n, int trails) {
            int sum = 0;
            for (int i = 0; i < trails; i++) {
                sum += countM(n);
            }
            return sum / trails;
        }
    
    }

```
## 2. Evidences:

### 2.1. Unit Tests ScreenShots:

![Unit Tests Passing Screenshot](/src/main/resources/screen_shots/UF_Unit_Tests.png)

### 2.2. UFClient observations:

#### The relationship between N and connections:

![The relationship between N and connections](/src/main/resources/screen_shots/relations_N_Connections.png)

#### The relationship between N and the pair of random numbers.

![The relationship between N and the pair of random numbers](/src/main/resources/screen_shots/relations_N_m.png)

## 3. Conclusion:

### 3.1 The relationship between n and the number of connections:

The relationship between the number of objects (n) and the number of connections
required to reduce the number of components from n to 1 can be expressed as
**connections = n - 1**. This conclusion is based on the idea that in a union-find
algorithm, each connection between two objects reduces the number of components
by 1. As a result, in order to reduce the number of components from n to 1, n-1
connections must be made.

For example, if we have 4 objects, we need to make 3 connections to connect them
all and form a single component. If we have 5 objects, we need to make 4
connections. Therefore, the relationship between n and the number of connections
can be expressed as connections = n - 1.

### 3.2 The relationship between n and the number of random numbers pair:

The relationship between n and the number of connections (m) in the
height-weighted Quick Union with Path Compression algorithm can be approximately
described as **m = 1/2*N * log N**. The logarithmic factor in this equation is a
result of the fact that, as the number of components decreases, the cost of
connecting two remaining components also decreases logarithmically.

In other words, as the number of components decreases, the algorithm has to work
less to connect the remaining components, as it only needs to update a smaller
number of parent pointers. This means that the algorithm is able to make use of
the fact that the structure of the components is becoming simpler and more like
a tree, reducing the amount of work required to connect two components. The 1/2
factor in the equation reflects the fact that, in the worst case, the algorithm
may have to try half of the possible pairs of components before finding two that
are not connected.
