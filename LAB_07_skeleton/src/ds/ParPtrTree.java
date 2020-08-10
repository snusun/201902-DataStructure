package ds;

import java.util.Arrays;

/**
 * General Tree class implementation for UNION/FIND
 */
public class ParPtrTree {
    private Integer[] array; // Node array
    private Integer[] size; // groupsize array. Consider only values of root nodes. We don't need to care others.
    private int maxSize;

    public ParPtrTree(int maxsize) {
        this.maxSize = maxsize;
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    public void clear() {
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    /**
     * Determine if nodes are in different trees
     */
    public boolean differ(Integer a, Integer b) {

        //TODO: fill your code
        //System.out.println("fill your code");
        //return false;
        int root1 = find(a);
        int root2 = find(b);
        if(root1 != root2) return true;
        else return false;
    }

    /**
     * Merge two subtrees using weighted union rule
     */
    public void union(Integer a, Integer b) { //큰게 루트로 가야한다

        //TODO: fill your code
        // follow "weighted union rule"
        // if group size of two values are equal, hang b's root to a's.
        //System.out.println("fill your code");
        /*int root1 = find(a);
        int root2 = find(b);
        //groupsize 이용
        if(root1 != root2)
        {
            if (groupSize(root1) > groupSize(root2) || groupSize(root1) == groupSize(root2)) {
                array[root1] = root2;
            } else if (groupSize(root1) < groupSize(root2)) {
                array[root2] = root1;
            }
        }*/
        Integer r1 = find(a);
        Integer r2 = find(b);
        if(!r1.equals(r2))
        {
            if (size[r1] >= size[r2])
            {
                array[r2] = r1;
                size[r1] += size[r2];
            }
            else
            {
                array[r1] = r2;
                size[r2] += size[r1];
            }
        }
    }

    /**
     * Find the root of the node using path compression
     */
    public Integer find(Integer curr) {
        //TODO: fill your code
        // use "path compression"
        //System.out.println("fill your code");
        //return null;
        if(array[curr] == null)
        {
            return curr;
        }
        array[curr] = find(array[curr]);
        return array[curr];
    }

    /**
     * Return the size of the graph that the node belongs to
     */
    public Integer groupSize(Integer curr) {
        //TODO: fill your code
        //System.out.println("fill your code");
        //return null;
        return this.size[find(curr)];
    }

    public Integer[] getSize() {
        return this.size;
    }

    public Integer[] getArray() {
        return this.array;
    }

    public void print() {
        System.out.println(Arrays.toString(array).replace("null", "N"));
    }


}
