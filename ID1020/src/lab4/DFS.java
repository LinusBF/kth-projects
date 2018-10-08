package lab4;

/**
 * Created by Linus on 2018-10-08.
 */
public class DFS {
    private ST<String, Boolean> marked;
    private int count;

    public DFS(GenericGraph<String> G, String root, String target){
        this.marked = new ST<>();
        for(String v : G.adj(root)){
            this.marked.put(v, false);
        }
        this.count = 0;
        this.dfs(G, root, target);
    }

    private void dfs(GenericGraph<String> G, String v, String w) {
        this.count++;
        this.marked.put(v, true);
        for (String a : G.adj(v)) {
            if (!this.marked.get(a)) {
                dfs(G, a, w);
            }
        }
    }

    public boolean marked(String v) {
        return this.marked.get(v);
    }

    public int count() {
        return count;
    }
}
