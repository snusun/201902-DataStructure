package ds.graph;


public class Prim {

    public static void findMST(Graph G) {
        // TODO: Fill in your code
		//print(G, parent);
        int v, w;
        Boolean[] isVisited = new Boolean[G.n()];
        double[] D = new double[G.n()];
        int[] prev = new int[G.n()];
        //int[] V = new int[G.n()];
        for(int i=0; i<G.n(); i++)
        {
            D[i] = Double.POSITIVE_INFINITY;
            isVisited[i] = false;
        }
        D[0] = 0;
        for(int i=0; i<G.n(); i++)
        {
            v = getNextVertex(G, D, isVisited);
            isVisited[v] = true;
            //if(v != 0) prev[v] = v;
            //if(D[v] == Double.POSITIVE_INFINITY) return; overflow x
            for(w=G.first(v); w<G.n(); w=G.next(v, w))
            {
                if(D[w] > G.weight(v, w) && !isVisited[w])
                {
                    D[w] = G.weight(v, w);
                    prev[w] = v;
                }
            }
        }
        print(G, prev);
    }


    public static void print(Graph G, int[] parent) {
        // TODO: Fill in your code
        int sum=0;
        for(int i=1; i<G.n(); i++)
        {
            System.out.println("Edge:" + parent[i] + " to " + i + ", weight:" + G.weight(parent[i], i));
            sum += G.weight(parent[i], i);
        }
        System.out.println("Total weight: " + sum);
    }

    public static int getNextVertex(Graph G, double key[], Boolean isVisited[]) {
    	// TODO: Fill in your code
        //minvertex
        int minvertex = -1;
        double minkey = Double.POSITIVE_INFINITY;
        for(int i=0; i<G.n(); i++)
        {
            if (!isVisited[i])
            {
                if(minkey>key[i])
                {
                    minkey = key[i];
                    minvertex = i;
                }
            }
        }
		return minvertex;
    }
}
