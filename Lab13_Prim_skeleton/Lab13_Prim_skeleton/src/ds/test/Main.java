package ds.test;

import ds.graph.Prim;
import ds.graph.Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Graph G = null;
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            String command = line[0];
//            System.out.println("Command: "+ command);
            if ("n".equals(command)) {
                int n = Integer.parseInt(line[1]);
                G = new Graph(n);
//                System.out.println("Make graph with "+n);
            } else if ("edge".equals(command)) {
                int src = Integer.parseInt(line[1]);
                int dst = Integer.parseInt(line[2]);
                double w = Double.parseDouble(line[3]);
                G.setEdge(src, dst, w);
//                System.out.println("Set edge "+src+", "+dst+", "+w);

            } else if ("mst".equals(command)) {
                Prim.findMST(G);
            }
        }
    }
}
