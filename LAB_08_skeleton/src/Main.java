import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        SortManager manager = new SortManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] cmd = line.split(" ");
            switch (cmd[0]) {
                case "SET_ITEMS":
                    int n = Integer.parseInt(cmd[1]);
                    String itemLine = scanner.nextLine();
                    manager.setItems(n, itemLine);
                    break;
                case "STABLE_SORT":
                    manager.doStableSelectionSort();
                    break;
                case "CHECK":
                    manager.check();
                    break;
                case "SHOW":
                    /* This command is for optional*/
                    manager.showStableSelectionSort();
                    break;
            }
            if (cmd[0].equals("EXIT")) {
                break;
            }

        }
    }
}
