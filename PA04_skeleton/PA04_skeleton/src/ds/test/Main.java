package ds.test;

import ds.hash.HashTable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int TABLE_SIZE = 577;
    private static final int ERROR = -1;
    private static final int CREATE = 0;
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int SEARCH = 3;
    private static final int PRINT = 4;


    public static void main(String[] args) throws IOException {
        HashTable hashTable = new HashTable(TABLE_SIZE);
        String filePath;

        try {
            /*
            Release filepath
            This will be used for evaluation
            (Recommended) Test using the following command:
                java -classpath <jar-file> ds.test.Main <path-to-sample-input>
             */
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            /*
            Debug filepath
            If FileNotFoundException occurs replace "sample_input.txt" with your sample_input absolute path
                Ex) "sample_input.txt" -> "/Users/hongildong/Documents/PA04/resources/sample_input.txt"
            */
            filePath = "sample_input.txt";
        }

        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            String[] lineSplit = line.split(" ");
            String cmd = lineSplit[0];

            int key;
            int c1, c2, c3;

            switch (getCommandNum(cmd)) {
                case CREATE:
                    c1 = Integer.parseInt(lineSplit[1]);
                    c2 = Integer.parseInt(lineSplit[2]);
                    c3 = Integer.parseInt(lineSplit[3]);
                    //TODO: fill your code
                    hashTable.create(c1, c2, c3);
                    break;
                case INSERT:
                    key = Integer.parseInt(lineSplit[1]);
                    //TODO: fill your code
                    hashTable.insert(key);
                    break;
                case DELETE:
                    key = Integer.parseInt(lineSplit[1]);
                    //TODO: fill your code
                    hashTable.delete(key);
                    break;
                case SEARCH:
                    key = Integer.parseInt(lineSplit[1]);
                    //TODO: fill your code
                    hashTable.search(key);
                    break;
                case PRINT:
                    //TODO: fill your code
                    hashTable.printAll();
                    break;
            }
        }
        reader.close();
    }

    private static int getCommandNum(String cmd) {
        switch (cmd) {
            case "create":
                return CREATE;
            case "insert":
                return INSERT;
            case "delete":
                return DELETE;
            case "search":
                return SEARCH;
            case "print":
                return PRINT;
            default:
                return ERROR;
        }
    }

}
