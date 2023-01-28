package edu.neu.coe.info6205.threesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
    private final int[] a;
    private final int length;

    /**
     * Construct a ThreeSumQuadratic on a.
     *
     * @param a a sorted array.
     */
    public ThreeSumQuadratic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        ThreeSumQuadratic tsq = new ThreeSumQuadratic(nums);
        Triple[] ts = tsq.getTriples();
        for (Triple t : ts) {
            System.out.println(t);

        }
//        List<Triple> res = tsq.getTriples(1);
//        System.out.println(res);
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++) triples.addAll(getTriples(i));
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    /**
     * Get a list of Triples such that the middle index is the given value j.
     *
     * @param j the index of the middle value.
     * @return a Triple such that
     */
    public List<Triple> getTriples(int j) {
        List<Triple> triples = new ArrayList<>();
        // FIXME : for each candidate, test if a[i] + a[j] + a[k] = 0.
        for (int i = 0; i < j; i++) {
            for (int k = j + 1; k < a.length; k++) {
                if (a[i] + a[j] + a[k] == 0) {
                    Triple temp = new Triple(a[i], a[j], a[k]);
                    boolean duplicate = false;
                    for (Triple t : triples) {
                        if (t.equals(temp)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (!duplicate) triples.add(temp);
                }
            }
        }
        return triples;
    }
}
