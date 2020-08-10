import jdk.jfr.Threshold;

public class Main {
    public static void main(String[] args) {

        /*
        int[] array = {6, 3, 2, 5, 1, 0, 5, 3, 4};
        int[] sort = sort(array);
        for(int i=0; i<sort.length; i++)
        {
            System.out.println(sort[i]);
        }
        */
    }

    public static int[] sort(int[] array)
    {
        int[] aux = new int[array.length];
        int min = array[0];
        int max = array[0];
        for(int i=1; i<array.length; i++)
        {
            if(array[i] < min)
            {
                min = array[i];
            }
            else if(array[i] > max)
            {
                max = array[i];
            }
        }
        int[] counts = new int[max-min+1];
        for(int i=0; i<counts.length; i++)
        {
            counts[i] = 0;
        }
        for(int i=0; i<array.length; i++)
        {
            counts[array[i]-min]++;
        }
        counts[0]--;
        for(int i=1; i<counts.length; i++)
        {
            counts[i] = counts[i] + counts[i-1];
        }
        for(int i=0; i<counts.length; i++)
        {
            System.out.println(counts[i]);
        }
        System.out.println("-------");
        for(int i= array.length-1; i>=0; i--)
        {
            aux[counts[array[i]-min]--] = array[i];
        }
        return aux;
    }

    public void mergeSort(int[] a, int[] temp, int l, int r)
    {
        int mid = (l + r) / 2;
        if(l ==r) return;
        if(mid - l > Threshold)
    }
}
