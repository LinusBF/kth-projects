package lab4;

import java.util.Scanner;

/**
 * Created by Linus on 2018-10-08.
 */
public class Graph implements GenericGraph<String>{
    private int V;
    private int E;
    private ST<String, Bag<String>> adj;

    Graph (Scanner s) {
        this.V = 0;
        this.E = 0;
        this.adj = new ST<>();
        while (s.hasNext()){
            String v = s.next();
            String w = s.next();
            addEdge(v, w);
        }
    }

    public Iterable<String> vertices() {return adj.keys();}

    public int V() {return this.V;}

    public int edges() {return this.E;}

    public void addEdge(String v, String w) {
        if(!this.adj.contains(v)){
            Bag<String> b = new Bag<>();
            this.adj.put(v, b);
            this.V++;
        }
        if(!this.adj.contains(w)){
            Bag<String> b = new Bag<>();
            this.adj.put(w, b);
            this.V++;
        }

        this.adj.get(v).add(w);
        this.adj.get(w).add(v);
        this.E++;
    }

    public Iterable<String> adj(String v){
        return this.adj.get(v);
    }
}
