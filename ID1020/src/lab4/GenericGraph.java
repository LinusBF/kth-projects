package lab4;

/**
 * Created by Linus on 2018-10-08.
 */
public interface GenericGraph<NodeType, EdgeType> {
    Iterable<String> vertices();
    int V();
    int edges();
    void addEdge(NodeType v, EdgeType w);
    Iterable<EdgeType> adj(NodeType v);
}
