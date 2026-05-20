import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<V> {
    private List<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        
    }

    public List<Vertex<V>> getVertices() {
        return vertices;
    }
}
