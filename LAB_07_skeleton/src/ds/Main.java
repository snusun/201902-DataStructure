package ds;

import java.io.*;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.Scanner;

import ds.ParPtrTree;

public class Main {
    private static final int ERROR = -1;
    private static final int UNION = 0;
    private static final int GROUPSIZE = 1;
    private static final int DIFFER = 2;
    private static final int FIND = 3;
    private static final int S_ISLAND = 4;
    private static final int T_ISLAND = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 15;
        ParPtrTree PPT = new ParPtrTree(size);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Scanner i_scanner = new Scanner(new StringReader(line));
            String cmd = i_scanner.next();
            int Node1 = 0;
            int Node2 = 0;

            //PPT.print(); // use it for self-checking

            switch (getCommandNum(cmd)) {
                case UNION:
                    Node1 = i_scanner.nextInt();
                    Node2 = i_scanner.nextInt();

                    // TODO: fill your code
                    // Print statement and call union function.
                    //System.out.println("fill your code");
                    //break;
                    System.out.printf("Union %2d and %2d\n", Node1, Node2);
                    PPT.union(Node1, Node2);
                    break;

                case GROUPSIZE:
                    Node1 = i_scanner.nextInt();

                    // TODO: fill your code
                    // Call union function and print statement.
                    //System.out.println("fill your code");
                    //break;
                    Integer s = PPT.groupSize(Node1);
                    System.out.println("GROUPSIZE: " + (s));
                    break;

                case DIFFER:
                    Node1 = i_scanner.nextInt();
                    Node2 = i_scanner.nextInt();

                    // TODO: fill your code
                    // Call differ function and print statement.
                    //System.out.println("fill your code!!");
                    boolean diff = PPT.differ(Node1, Node2);
                    if(diff)
                    {
                        System.out.println("DIFFER: YES");
                    }
                    else
                    {
                        System.out.println("DIFFER: NO");
                    }
                    break;

                case FIND:
                    Node1 = i_scanner.nextInt();
                    //TODO: fill your code
                    //Call find function and print statement.
                    //System.out.println("fill your code!");
                    Integer root = PPT.find(Node1);
                    System.out.printf("%2d's ROOT: %d\n", Node1, root);
                    break;

                case S_ISLAND:
                    Integer[][] s_map = get2DMap("sample_map.txt", 4);
                    //print2Darray(s_map);
                    Island sample_island = new Island(s_map, 4);
                    sample_island.segmentMap();
                    int s_num = sample_island.getIslandNum();
                    System.out.printf("Sample map consists of %2d islands.\n", s_num);
                    break;

                case T_ISLAND:
                    Integer[][] t_map = get2DMap("test_map.txt", 15);
                    Island test_island = new Island(t_map, 15);
                    //print2Darray(t_map);
                    test_island.segmentMap();
                    int t_num = test_island.getIslandNum();
                    System.out.printf("Test map consists of %2d islands.\n", t_num);


                    break;
                case ERROR:
                    System.out.println("ERROR: Unknown command");
                    break;
            }
            i_scanner.close();
        }

        scanner.close();
    }

    private static int getCommandNum(String cmd) {
        //System.out.println(cmd);
        if (cmd.equals("union"))
            return UNION;
        else if (cmd.equals("groupsize"))
            return GROUPSIZE;
        else if (cmd.equals("differ"))
            return DIFFER;
        else if (cmd.equals("find"))
            return FIND;
        else if (cmd.equals("sample_map"))
            return S_ISLAND;
        else if (cmd.equals("test_map"))
            return T_ISLAND;
        else
            return ERROR;
    }

    public static void print2Darray(Integer[][] arr) {
        int r0 = arr.length;
        int c0 = arr[0].length;

        for (int r = 0; r < r0; r++) {
            for (int c = 0; c < c0; c++) {
                System.out.printf("%d ", arr[r][c]);
            }
            System.out.println();
        }
    }

    public static Integer[][] get2DMap(String file_name, int map_size) {
        Integer[][] map = new Integer[map_size][map_size];
        File file = new File(file_name);
        try {
            FileReader file_reader = new FileReader(file);
            BufferedReader bf = new BufferedReader(file_reader);
            String l = "";
            int ln = 0;
            while ((l = bf.readLine()) != null) {
                //System.out.println(l);
                String[] tmp = l.split(" ");
                for (int idx = 0; idx < map_size; idx++) {
                    map[ln][idx] = Integer.parseInt(tmp[idx]);
                }
                ln++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return map;
    }
}

