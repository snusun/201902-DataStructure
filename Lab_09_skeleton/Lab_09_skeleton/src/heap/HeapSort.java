package heap;

import java.util.Arrays;

public class HeapSort<E extends Comparable<? super E>> {
    private MinHeap<E> minHeap;
    private int n;
    private E[] array;

    private static final int SORT_A = 2;
    private static final int SORT_D = 3;

    public HeapSort(int n){
        array = newArray(n);
        minHeap = new MinHeap<E>(array, 0, n);
        this.n = n;
    }

    public void add(E value){
        // fill your code
        minHeap.insert(value);
        minHeap.printHeap();
    }

    public void remove(E value){
        // fill your code
        minHeap.remove(minHeap.find(value));
        minHeap.printHeap();
    }

    public void sort(int order){
        // fill your code
        //E[] arr = newArray(n, array);
        int heapsize = minHeap.heapsize();
        E[] sorted = newArray(heapsize);
        if(order == SORT_D)
        {
            for(int i=heapsize-1; i>=0; i--)
            {
                sorted[i] = minHeap.removeMin();
            }
        }
        else
        {
            for(int i=0; i<heapsize; i++)
            {
                sorted[i] = minHeap.removeMin();
            }
        }
        for(int i=0; i<heapsize; i++)
        {
            System.out.print(sorted[i].toString());
            System.out.print(" ");
        }
        System.out.println();

        minHeap.setSize(heapsize);
        minHeap.buildheap();

        System.out.print("\t\t");
        minHeap.printHeap();
        //minHeap.removeMin();
        /*for(int i=0; i<n; i++)
        {
            arr[i] = minHeap.removeMin();
        }
        if(order==2) //오름차순
        {
            for(int i=0; i<arr.length; i++)
            {
                System.out.print(arr[i] + " ");
                System.out.println();
            }
        }
        else if(order==3) //내림차순
        {
            for(int i=arr.length-1; i>-1; i--)
            {
                System.out.print(arr[i] + " ");
                System.out.println();
            }
        }*/
        //minHeap.buildheap();
        //minHeap.printHeap();
    }

    //This function is for allocating an generic array of size n
    private static <E> E[] newArray(int length, E... array)
    {
        return Arrays.copyOf(array, length);
    }
}
