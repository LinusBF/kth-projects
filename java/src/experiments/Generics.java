package experiments;

/**
 * Created by Linus on 2018-01-08.
 */
public class Generics<K, E> {
    private K k;
    private E e;

    public Generics(K k, E e) {
        this.k = k;
        this.e = e;
    }

    @Override
    public String toString() {
        return this.k +" --> " + this.e;
    }
}
