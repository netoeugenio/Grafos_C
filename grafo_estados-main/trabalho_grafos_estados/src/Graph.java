
public class Graph {
    private final int V;       // número de vértices
    private int E;             // número de arestas
    private Bag<Integer>[] adj; // lista de adjacência

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;

        // cria um Bag para cada vértice
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }

  
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    // Retorna os vizinhos de um vértice
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}