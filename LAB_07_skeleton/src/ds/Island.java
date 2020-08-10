package ds;

public class Island {
    private ParPtrTree ppt;
    private Integer[][] map;
    private int map_size;

    public Island(Integer[][] m, int ms) {
        this.map = m;
        this.map_size = ms;
        ppt = new ParPtrTree(map_size * map_size);
    }

    /**
     * Segment map using union and find function in ppt (point pointer tree)
     * Hint: you can represents 2-d array as 1-d array by flattening.
     * For row r and col c -> 1-d index = row * (row_size) + col
     */
    public void segmentMap() {
        //TODO: fill your code
        //System.out.println("fill your code");
        for(int i=0; i<map_size; i++)
        {
            for(int j=0; j<map_size; j++)
            {

            }
        }
    }

    /**
     * get the number of the islands using array of ppt
     */
    public int getIslandNum() {
        // TODO: fill your code
        System.out.println("fill your code");
        return 99;
    }

    public int[] getIslandSize() {
        // TODO: optional problem, fill your code if you want
        // Hint: use Arrays.sort() to sort array
        return null;
    }
}
