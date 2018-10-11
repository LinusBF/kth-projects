package lab4;

/**
 * Created by Linus on 2018-10-10.
 */
public class DFSWeight {
    private ST<String, Boolean> marked;
    private ST<String, Integer> distanceTo;
    private ST<String, String> edgeTo;
    private String source;
    private int count;

    public DFSWeight(GenericGraph<String, Edge<String, Integer>> G, String s){
        this.marked = new ST<>();
        this.edgeTo = new ST<>();
        this.distanceTo = new ST<>();
        this.count = 0;
        this.source = s;
        dfs(G, s);
    }


    private void dfs(GenericGraph<String, Edge<String, Integer>> G, String v) {
        this.marked.put(v, true);
        for (Edge<String, Integer> w : G.adj(v)) {
            String wStr = w.other(v);
            this.count += w.weight();
            if(!this.marked.contains(wStr)) this.marked.put(wStr, false);
            if(!this.distanceTo.contains(wStr)) this.distanceTo.put(wStr, this.count);
            if (!this.marked.get(wStr)) {
                this.edgeTo.put(wStr, v);
                dfs(G, w.other(v));
            }
            if(this.count < this.distanceTo.get(wStr)){
                this.distanceTo.put(wStr, this.count);
                this.edgeTo.put(wStr, v);
                dfs(G, w.other(v));
            }
            this.count -= w.weight();
        }
    }

    public boolean hasPathTo(String v) {
        return this.marked.get(v);
    }

    public Integer pathTo(String v){
        if(!this.hasPathTo(v)) return null;
        LinkedQueue<String> path = new LinkedQueue<>();
        for(String x = v; !x.equals(this.source); x = edgeTo.get(x)){
            path.enqueue(x);
        }
        path.enqueue(this.source);

        for (String s : path){
            System.out.print(s + (!s.equals(this.source) ? " -> " : "\n"));
        }

        return this.distanceTo.get(v);
    }
}
