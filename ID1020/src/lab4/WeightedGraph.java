package lab4;

import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-10-09.
 */
public class WeightedGraph implements GenericGraph<String, Edge<String, Integer>> {
    private int V;
    private int E;
    private ST<String, Bag<Edge<String, Integer>>> adj;

    WeightedGraph (Scanner s) {
        this.V = 0;
        this.E = 0;
        this.adj = new ST<>();
        while (s.hasNext()){
            String v = s.next();
            String w = s.next();
            Integer weight = s.nextInt();
            addEdge(v, new Edge<>(v, w, weight));
        }
    }

    @Override
    public Iterable<String> vertices() {return adj.keys();}

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(String v, Edge<String, Integer> w) {
        if(!this.adj.contains(v)){
            Bag<Edge<String, Integer>> b = new Bag<>();
            this.adj.put(v, b);
            this.V++;
        }
        if(!this.adj.contains(w.other(v))){
            Bag<Edge<String, Integer>> b = new Bag<>();
            this.adj.put(w.other(v), b);
            this.V++;
        }

        this.adj.get(v).add(w);
        this.adj.get(w.other(v)).add(w.flipped());
        this.E++;
    }

    @Override
    public Iterable<Edge<String, Integer>> adj(String v) {
        return this.adj.get(v);
    }

    public Iterable<Edge<String, Integer>> edges()
    {
        Bag<Edge<String, Integer>> b = new Bag<>();
        for (String v : this.vertices())
            for (Edge<String, Integer> e : adj.get(v))
                if (!e.other(v).equals(v)) b.add(e);
        return b;
    }
}
