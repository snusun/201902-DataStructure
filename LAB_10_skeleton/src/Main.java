import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        SearchManager manager = new SearchManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            //System.out.println(line);
            String[] cmd = line.split(" ");
            BigInteger target;
            int idx = -1;
            switch (cmd[0]) {
                case "SET_ITEMS":
                    char type = (cmd[1]).charAt(0);
                    int n = Integer.parseInt(cmd[2]);
                    int a0 = Integer.parseInt(cmd[3]);
                    int d = Integer.parseInt(cmd[4]);
                    manager.setItems(type, n, a0, d);
                    break;

                case "FIND_B":
                    target = new BigInteger(cmd[1]);
                    idx = manager.doBinarySearch(target);
                    break;

                case "FIND_I":
                    target = new BigInteger(cmd[1]);
                    idx = manager.doInterpolationSearch(target);
                    break;

                case "FIND_J":
                    target = new BigInteger(cmd[1]);
                    idx = manager.doJumpSearch(target);
                    break;
            }
            if (cmd[0].equals("EXIT")) {
                break;
            }

        }
    }
}
