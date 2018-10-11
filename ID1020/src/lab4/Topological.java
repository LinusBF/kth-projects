package lab4;

/**
 * Created by Linus on 2018-10-11.
 */
public class Topological {
    private Iterable<String> order;

    public Topological(DirectedGraph G){
        DFO dfs = new DFO(G);
        order = dfs.reversePost();
    }
    public Iterable<String> order()
    { return order; }
    public boolean isDAG()
    { return order == null; }
}
