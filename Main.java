public class Main {
    public static void main(String[] args) {
        // 1. Создаем вершины (теперь это объекты Vertex)
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> aktau = new Vertex<>("Aktau");

        // 2. Создаем граф и добавляем вершины
        WeightedGraph<String> map = new WeightedGraph<>();
        map.addVertex(astana);
        map.addVertex(almaty);
        map.addVertex(shymkent);
        map.addVertex(aktau);

        // 3. Добавляем ребра с весами (как на скриншоте задания)
        map.addEdge(astana, almaty, 1200.0);
        map.addEdge(almaty, shymkent, 700.0);
        map.addEdge(shymkent, aktau, 1500.0);
        map.addEdge(astana, aktau, 2500.0);

        // 4. Тестируем Dijkstra (кратчайший путь по весам)
        System.out.println("--- Dijkstra Search ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(astana);
        if (dijkstra.hasPathTo(aktau)) {
            System.out.print("Path from Astana to Aktau: ");
            for (Vertex<String> v : dijkstra.pathTo(aktau)) {
                System.out.print(v.getData() + " -> ");
            }
            System.out.println("Done");
        }

        // 5. Тестируем BFS (поиск по количеству прыжков)
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