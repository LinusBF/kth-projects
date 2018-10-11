package lab4;

/**
 * Created by Linus on 2018-10-11.
 */
public class DFO {
    private ST<String, Boolean> marked;
    private LinkedQueue<String> pre;
    private LinkedQueue<String> post;
    private Stack<String> reversePost;

    public DFO(DirectedGraph G){
        this.marked = new ST<>();
        this.pre = new LinkedQueue<>();
        this.post = new LinkedQueue<>();
        this.reversePost = new Stack<>();

        for(String v : G.vertices()){
            this.marked.put(v, false);
        }
        for(String v : G.vertices()){
            if(!this.marked.get(v)) dfs(G, v);
        }
    }

    private void dfs(DirectedGraph G, String v){
        this.pre.enqueue(v);
        this.marked.put(v, true);
        for(String w : G.adj(v)){
            if(!this.marked.get(w)) dfs(G, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<String> pre()
    { return pre; }
    public Iterable<String> post()
    { return post; }
    public Iterable<String> reversePost()
    { return reversePost; }
}
