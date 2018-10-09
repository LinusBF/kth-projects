package lab4;

/**
 * Created by Linus on 2018-10-08.
 */
public interface GenericGraph<Type> {
    Iterable<String> vertices();
    int V();
    int edges();
    void addEdge(Type v, Type w);
    Iterable<Type> adj(Type v);
}
