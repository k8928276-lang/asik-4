import java.util.*;

public abstract class Search<V> {
    protected Map<Vertex<V>, Vertex<V>> edgeTo; 
    protected Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) {
        return edgeTo.containsKey(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = v; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }
}
