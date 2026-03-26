import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    private List<Integer> visitOrder;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        visitOrder = new ArrayList<>();
        this.s = s;

        bfs(G, s);
    }

    
     //BFS usando fila
     
    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();

        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            visitOrder.add(v); // ordem de saída da fila

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    
     //Reconstrói o caminho mínimo até v
     
    public Iterable<Integer> pathTo(int v) {
        List<Integer> path = new ArrayList<>();
        if (!hasPathTo(v)) return path;

        for (int x = v; x != s; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    // ordem em que os vértices foram visitados durante uma
    public List<Integer> getVisitOrder() {
        return visitOrder;
    }

    public List<Integer> reachable() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) list.add(i);
        }
        return list;
    }
}