import java.math.BigInteger;
import java.net.PasswordAuthentication;
import java.util.concurrent.TimeUnit;

public class SearchManager {
    BigInteger[] items;
    int N = -1;

    public SearchManager() {
    }

    /**
     * Set items for the 'this.itmes' array using arithmetic or geometric sequence.
     * Print the elements in the array using 'print' function at the end of the code.
     * Hint. You have to use BigInteger1.add(BigInteger2) or BigInteger1.multiply(BigInteger2)
     * when you add or multiply BigIntegers.
     * Hint. You have to use 'new BigInterger("STRING TYPE VALUE")' to generate new BigInteger Instance.
     * e.g. a = new BigInteger("1234567890123456789")
     *
     * @param type 'A' for arithmetic, 'G" for geometric sequence.
     * @param n    the number of elements.
     * @param a0   the initial value.
     * @param d    commom difference/ ratio of the sequence.
     */
    public void setItems(char type, int n, int a0, int d) {
        this.N = n;
        this.items = new BigInteger[n];
        ///TODO: fill in the code
        //System.out.println("setItems");
        BigInteger common = new BigInteger(Integer.toString(d));
        this.items[0] = new BigInteger(Integer.toString(a0));
        if(type == 'A')
        {
            for(int i=1; i<n; i++)
            {
                this.items[i] = common.add(this.items[i-1]);
            }
        }
        else if(type == 'G')
        {
            for(int i=1; i<n; i++)
            {
                this.items[i]= common.multiply(this.items[i-1]);
            }
        }
        print();
    }

    /**
     * Find the index of the target in "this.items" using jump search and count the number of comparisons.
     * Print "[J] Index: (index), count: (count)" if you find the target.
     * Print "[J] Not found, count: (count)" if there is no target in the "this.items".
     * Hint. Use BigInteger1.compareTo(BigInteger2) when you compare two BigInteger instances.
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doJumpSearch(BigInteger target) {
        if (this.N == -1) {
            System.out.println("[J] The array is empty.");
            return -1;
        }
        ///TODO: fill in the code
        //System.out.println("doJumpSearch");
        //return -1;
        int k =  (int)Math.sqrt(N);
        int count = 0;
        int i = 0;
        for(i = k-1; i<N; i+= k)
        {
            count++;
            if(target.compareTo(items[i]) > 0)
            {
                //count++;
                if(N-i <= k)
                {
                    System.out.println("[j] Not found, count: " + count);
                    return -1;
                }
            }
            else if(target.compareTo(items[i]) == 0)
            {
                //count++;
                System.out.println("[j] Index: " + i + ", count: "+ count);
                return -1;
            }
            else if(target.compareTo(items[i]) < 0)
                //count++;
                break;
        }

        for(int j = (i+1) - k; j<N; j++)
        {
            count++;
            if(target.compareTo(items[j]) > 0)
            {
                //count++;
            }
            else if(target.compareTo(items[j]) == 0)
            {
                //count++;
                System.out.println("[j] Index: " + j + ", count: "+ count);
                return -1;
            }
            else if(target.compareTo(items[j]) < 0)
            {
                //count++;
                break;
            }
        }
        System.out.println("[j] Not found, count: " + count);
        return -1;
    }

    /**
     * Find the index of the target in "this.items" using binary search and count the number of comparisons.
     * Print "[B] Index: (index), count: (count)" if you find the target.
     * Print "[B] Not found, count: (count)" if there is no target in the "this.items".
     * Hint. Use BigInteger1.compareTo(BigInteger2) when you compare two BigInteger instances.
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doBinarySearch(BigInteger target) {
        if (this.N == -1) {
            System.out.println("[J] The array is empty.");
            return -1;
        }
        ///TODO: fill in the code
        //System.out.println("doBinarySearch");
        int count = 0;
        int right = N-1;
        int left = 0;
        int mid = (right - left) / 2 + left;
        while (left <= right)
        {
            if(target.compareTo(items[mid]) > 0)
            {
                count++;
                left = mid + 1;
                mid = (right - left) / 2 + left;
            }
            else if(target.compareTo(items[mid]) < 0)
            {
                count++;
                right = mid - 1;
                mid = (right - left) / 2 + left;
            }
            else if(target.compareTo(items[mid]) == 0)
            {
                count++;
                System.out.println("[B] Index: " + mid + ", count: "+ count);
                return -1;
            }
        }
        System.out.println("[B] Not found, count: " + count);
        return -1;
    }

    /**
     * Print the list of elements in the 'this.items'.
     */
    public void print() {
        if (this.N == -1) {
            System.out.println("There are no items to print");
        }
        String str = "";
        for (int i = 0; i < N; i++) str += this.items[i] + " ";
        System.out.println(str);
    }

    /*----------------------------------- Optional Problem ----------------------------------------------*/

    /**
     * Find the index of the target in "this.items" using interpolation search and count the number of comparisons.
     * Print "[I] Index: (index), count: (count)" if you find the target.
     * Print "[I] Not found, count: (count)" if there is no target in the "this.items".
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doInterpolationSearch(BigInteger target) {
        ///TODO: fill in the code
        System.out.println("doInterpolationSearch");
        return -1;
    }
}