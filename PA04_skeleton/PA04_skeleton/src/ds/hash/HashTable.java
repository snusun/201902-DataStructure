package ds.hash;

public class HashTable {
    private int[] table;
    private int c1, c2, c3;
    private int delMarker = -1;
    private int tableSize;

    public HashTable(int n) {
        //TODO: fill your code
        tableSize = n;
        table = new int[tableSize];
    }

    public void create(int c1, int c2, int c3) {
        //TODO: fill your code
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void insert(int key) {
        //TODO: fill your code
        int i=0;
        int index = quadProb(key, i);
        while(table[index] != 0)
        {
            i++;
            index = quadProb(key, i);
        }
        table[index] = key;
        System.out.println("INSERT: " + key + " / INDEX: " + index);
    }

    public void delete(int key) {
        //TODO: fill your code
        for(int i=0; i<tableSize; i++)
        {
            if(table[quadProb(key, i)] == key)
            {
                System.out.println("DELETE: " + key + " / INDEX: " + quadProb(key, i));
                table[quadProb(key, i)] = delMarker;
                return;
            }
        }
        System.out.println("Failed to find " + key);
    }

    public void search(int key) {
        //TODO: fill your code
        for(int i=0; i<tableSize; i++)
        {
            if(table[quadProb(key, i)] == key)
            {
                System.out.println("SEARCH: " + key + " / INDEX: " + quadProb(key, i));
                return;
            }
        }
        System.out.println("Failed to find " + key);
    }

    public void printAll() {
        //TODO: fill your code
        int i=0;
        for(; i<tableSize; i++)
        {
            if(table[i] != 0)
            {
                System.out.print(table[i]+"("+i+")");
                break;
            }
        }
        i++;
        for(; i<tableSize; i++)
        {
            if(table[i] != 0)
            {
                System.out.print(", " + table[i] + "(" + i + ")");
            }
        }
        System.out.println();
    }

    private int quadProb(int k, int i) {
        //TODO: fill your code
        int P = c1*i*i + c2*i + c3;
        int quad = (k + P) % tableSize;
        return quad;
    }
}
