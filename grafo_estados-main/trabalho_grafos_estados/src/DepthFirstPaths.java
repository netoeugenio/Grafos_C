import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DepthFirstPaths {
    private boolean[] marked;   // marca vértices visitados
    private int[] edgeTo;       // guarda caminho
    private final int s;        // origem
    private List<Integer> visitOrder; // ordem de visita

    public DepthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.visitOrder = new ArrayList<>();
        this.s = s;

        dfs(G, s);
    }

    
      //DFS recursiva
     
    private void dfs(Graph G, int v) {
        marked[v] = true;         // marca como visitado
        visitOrder.add(v);        // salva ordem de visita

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;    // guarda de onde veio
                dfs(G, w);        // continua exploração
            }
        }
    }

    // Verifica se existe caminho até v
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    
     //Reconstrói o caminho da origem até v
     
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<>();
        if (!hasPathTo(v)) return path;

        for (int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path); // inverte para ordem correta
        return path;
    }

    // Retorna ordem de visita
    public List<Integer> getVisitOrder() {
        return visitOrder;
    }

    
     //Retorna todos os vértices alcançáveis a partir da origem
     
    public List<Integer> reachable() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) list.add(i);
        }
        return list;
    }
}