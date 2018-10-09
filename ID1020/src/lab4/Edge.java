package lab4;

/**
 * Created by Linus Bein Fahlander on 2018-10-09.
 */
public class Edge<Item, Weight extends Comparable<Weight>> implements Comparable<Edge<Item, Weight>> {
    private final Item v;
    private final Item w;
    private final Weight weight;

    public Edge(Item v, Item w, Weight weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public Weight weight() {
        return this.weight;
    }

    public Item either(){
        return this.v;
    }

    public Item other(Item i) {
        return (i == this.v ? this.w : this.v);
    }

    public Edge<Item, Weight> flipped(){
        return new Edge<>(this.other(this.either()), this.either(), this.weight);
    }

    @Override
    public int compareTo(Edge<Item, Weight> o) {
        return this.weight().compareTo(o.weight());
    }
}
