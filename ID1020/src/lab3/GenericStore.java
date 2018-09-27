package lab3;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public interface GenericStore<Key extends Comparable<Key>, Value> {
    public void put(Key k, Value v);
    public Value get(Key k);
    public boolean contains(Key k);
    public Iterable<Key> keys();
}
