package lab4;

/**
 * Created by Linus on 2018-10-08.
 */
public class DFS {
    private ST<String, Boolean> marked;
    private ST<String, Integer> distanceTo;
    private ST<String, String> edgeTo;
    private final String source;
    private int count;

    public DFS(GenericGraph<String> G, String s){
        this.marked = new ST<>();
        this.distanceTo = new ST<>();
        this.edgeTo = new ST<>();
        this.source = s;
        this.count = 0;
        this.dfs(G, s);
    }

    private void dfs(GenericGraph<String> G, String v) {
        this.count++;
        this.marked.put(v, true);
        for (String w : G.adj(v)) {
            if(!this.marked.contains(w)) this.marked.put(w, false);
            if(!this.distanceTo.contains(w)) this.distanceTo.put(w, count);
            if (!this.marked.get(w)) {
                this.edgeTo.put(w, v);
                dfs(G, w);
            }
            if(this.count < this.distanceTo.get(w)){
                this.distanceTo.put(w, this.count);
                this.edgeTo.put(w, v);
                dfs(G, w);
            }
        }
        this.count--;
    }

    public boolean hasPathTo(String v) {
        return this.marked.get(v);
    }

    public int count() {
        return count;
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
