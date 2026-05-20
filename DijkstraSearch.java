import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distTo; 
    private PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(Vertex<V> source) {
        super(source);
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distTo.get(v)));

        dijkstra(source);
    }

    private void dijkstra(Vertex<V> source) {
        distTo.put(source, 0.0);
        pq.add(source);
        edgeTo.put(source, null);

        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                relax(v, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> v, Vertex<V> w, double weight) {
        double newDist = distTo.get(v) + weight;
        if (newDist < distTo.getOrDefault(w, Double.POSITIVE_INFINITY)) {
            distTo.put(w, newDist);
            edgeTo.put(w, v);
            pq.add(w);
        }
    }
}
