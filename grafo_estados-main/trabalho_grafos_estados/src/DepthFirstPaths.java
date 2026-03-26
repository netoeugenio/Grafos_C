import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    private List<Integer> visitOrder; // Garante os pontos da Pergunta 5

    public DepthFirstPaths(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.visitOrder = new ArrayList<>();
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        visitOrder.add(v); // Salva a ordem exata da visita
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> path = new ArrayList<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public List<Integer> getVisitOrder() {
        return visitOrder;
    }
}