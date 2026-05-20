public class Main {
    public static void main(String[] args) {
       
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> aktau = new Vertex<>("Aktau");

     
        WeightedGraph<String> map = new WeightedGraph<>();
        map.addVertex(astana);
        map.addVertex(almaty);
        map.addVertex(shymkent);
        map.addVertex(aktau);

        map.addEdge(astana, almaty, 1200.0);
        map.addEdge(almaty, shymkent, 700.0);
        map.addEdge(shymkent, aktau, 1500.0);
        map.addEdge(astana, aktau, 2500.0);

       
        System.out.println("--- Dijkstra Search ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(astana);
        if (dijkstra.hasPathTo(aktau)) {
            System.out.print("Path from Astana to Aktau: ");
            for (Vertex<String> v : dijkstra.pathTo(aktau)) {
                System.out.print(v.getData() + " -> ");
            }
            System.out.println("Done");
        }

      
        System.out.println("\n--- BFS Search ---");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(astana);
        if (bfs.hasPathTo(shymkent)) {
            System.out.print("BFS path to Shymkent: ");
            for (Vertex<String> v : bfs.pathTo(shymkent)) {
                System.out.print(v.getData() + " -> ");
            }
            System.out.println("Done");
        }
    }
}
