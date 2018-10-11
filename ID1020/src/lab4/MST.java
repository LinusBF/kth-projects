package lab4;

/**
 * Created by Linus on 2018-10-11.
 */
public class MST {
    private ST<String, Boolean> marked;
    private LinkedQueue<Edge<String, Integer>> mst;
    private MinPQ<Edge<String, Integer>> pq;

    public MST(GenericGraph<String, Edge<String, Integer>> G){
        this.pq = new MinPQ<>();
        this.marked = new ST<>();
        mst = new LinkedQueue<>();
        for(String v : G.vertices()){
            this.marked.put(v, false);
        }
        visit(G, this.getMaxEdge(G).either()); // Start with heaviest Edge in graph
        while (!pq.isEmpty())
        {
            Edge<String, Integer> e = pq.delMin();
            String v = e.either(), w = e.other(v);
            if (marked.get(v) && marked.get(w)) continue;
            mst.enqueue(e);
            if (!marked.get(v)) visit(G, v);
            if (!marked.get(w)) visit(G, w);
        }
    }

    private Edge<String, Integer> getMaxEdge(GenericGraph<String, Edge<String, Integer>> G){
        Edge<String, Integer> maxEdge = null;
        for(Edge<String, Integer> v : G.edges()){
            if(maxEdge == null || v.compareTo(maxEdge) > 0){
                maxEdge = v;
            }
        }
        return maxEdge;
    }

    private void visit(GenericGraph<String, Edge<String, Integer>> G, String v){
        marked.put(v, true);
        for (Edge<String, Integer> e : G.adj(v))
            if (!marked.get(e.other(v))) pq.insert(e);
    }

    public Iterable<Edge<String, Integer>> edges()
    {
        return mst;
    }

    public Integer totalWeight(){
        Integer sum = 0;
        for(Edge<String, Integer> e : this.edges()){
            sum += e.weight();
        }

        return sum;
    }
}
