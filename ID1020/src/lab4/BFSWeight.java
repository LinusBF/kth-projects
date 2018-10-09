package lab4;

/**
 * Created by Linus Bein Fahlander on 2018-10-09.
 */
public class BFSWeight {
    private ST<String, Boolean> marked;
    private ST<String, Edge<String, Integer>> edgeTo;
    private final String source;

    public BFSWeight(GenericGraph<String, Edge<String, Integer>> G, String s){
        this.marked = new ST<>();
        this.edgeTo = new ST<>();
        this.source = s;
        bfs(G);
    }

    private void bfs(GenericGraph<String, Edge<String, Integer>> G){
        LinkedQueue<String> q = new LinkedQueue<>();
        this.marked.put(this.source, true);
        q.enqueue(this.source);
        while (!q.isEmpty()){
            String v = q.dequeue();
            for(Edge<String, Integer> w : G.adj(v)){
                if(!this.marked.contains(w.other(v))) this.marked.put(w.other(v), false);
                if(!this.marked.get(w.other(v))){
                    this.edgeTo.put(v, w);
                    this.marked.put(w.other(v), true);
                    q.enqueue(w.other(v));
                }
            }
        }
    }

    public boolean hasPathTo(String v) {
        return (this.marked.get(v) != null ? this.marked.get(v) : false);
    }

    public Iterable<String> pathTo(String v){
        if(!this.hasPathTo(v)) return null;
        LinkedQueue<String> path = new LinkedQueue<>();
        for(String x = v; !x.equals(this.source); x = edgeTo.get(x).other(x)){
            path.enqueue(x);
        }
        path.enqueue(this.source);
        return path;
    }
}
