package ds.graph;

import ds.queue.DistanceQueue;

public class Dijkstra {
    private DistanceQueue distQueue;
    private int[] prev;
    private double[] D;
    private Graph G;

    public Dijkstra(Graph G) {
    	D = new double[G.n()];
    	distQueue = new DistanceQueue(G.n());
    	prev = new int[G.n()];
    	this.G= G;
    }

    public void calculateShortestPath(Graph G, int start) {
        // Fill your code
        for(int i=0; i<G.n(); i++)
            D[i] = Double.POSITIVE_INFINITY;
        for(int i=0; i<G.n(); i++)
            distQueue.insert(i, D[i]);
        D[start] = 0;
        while(!distQueue.isEmpty())
        {
            int v = minVertex(G);
            for(int w = G.first(v); w < G.n(); w = G.next(v, w))
            {
                if(D[w] > (D[v]+ G.weight(v, w)))
                {
                    D[w] = D[v] + G.weight(v, w);
                    prev[w] = v;
                    distQueue.decreaseDistance(w, D[w]);
                }
            }
        }
    }

    private void printPathToEnd(Graph G, int end, int src) {
		int v = end;
		StringBuffer ss = new StringBuffer();

		// Fill your code
        while(v!=src)
        {
            ss.append(v+" ");
            v = prev[v];
        }
        ss.append(v+ " ");

    	System.out.println(ss.reverse().toString());
    }
    
    public void printAllPath(Graph G, int src) {    		
		// Fill your code
        for(int i=0;i<G.n(); i++)
        {
            System.out.print("PATH " + src + " " + i + ": " + D[i]);
            printPathToEnd(G, i, src);
        }
    }

    public int minVertex(Graph G) {
    	// Fill your code
        return distQueue.removeMin();
    }
}
