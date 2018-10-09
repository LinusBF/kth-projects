package lab4;

/**
 * Created by Linus on 2018-10-09.
 */
public class BFS {
    private ST<String, Boolean> marked;
    private ST<String, String> edgeTo;
    private final String source;

    public BFS(GenericGraph<String, String> G, String s){
        this.marked = new ST<>();
        this.edgeTo = new ST<>();
        this.source = s;
        bfs(G, s);
    }

    private void bfs(GenericGraph<String, String> G, String s){
        LinkedQueue<String> q = new LinkedQueue<>();
        this.marked.put(s, true);
        q.enqueue(s);
        while (!q.isEmpty()){
            String v = q.dequeue();
            for(String w : G.adj(v)){
                if(!this.marked.contains(w)) this.marked.put(w, false);
                if(!this.marked.get(w)){
                    this.edgeTo.put(w, v);
                    this.marked.put(w, true);
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(String v) {
        return this.marked.get(v);
    }

    public Iterable<String> pathTo(String v){
        if(!this.hasPathTo(v)) return null;
        LinkedQueue<String> path = new LinkedQueue<>();
        for(String x = v; !x.equals(this.source); x = edgeTo.get(x)){
            path.enqueue(x);
        }
        path.enqueue(this.source);
        return path;
    }
}
