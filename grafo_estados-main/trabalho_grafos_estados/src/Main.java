import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Mapeamento exigido pelo professor
    private static final String[] ESTADOS = {"AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"};
    private static final Map<String, Integer> SIGLA_PARA_ID = new HashMap<>();

    static {
        for (int i = 0; i < ESTADOS.length; i++) {
            SIGLA_PARA_ID.put(ESTADOS[i], i);
        }
    }

    public static void main(String[] args) {
        Graph G = null;
        
        try {
            File file = new File("dados/nordeste.txt");
            if (!file.exists()) {
                file = new File("../dados/nordeste.txt"); 
            }
            
            Scanner fileScanner = new Scanner(file);
            int V = fileScanner.nextInt();
            int E = fileScanner.nextInt();
            G = new Graph(V);
            
            for (int i = 0; i < E; i++) {
                int v = fileScanner.nextInt();
                int w = fileScanner.nextInt();
                G.addEdge(v, w);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo dados/nordeste.txt não encontrado!");
            return;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("=== Análise de Fronteiras do Nordeste ===");
        System.out.print("Digite a sigla do estado de origem (ex: CE): ");
        String origem = input.next().toUpperCase();
        System.out.print("Digite a sigla do estado de destino (ex: BA): ");
        String destino = input.next().toUpperCase();

        if (!SIGLA_PARA_ID.containsKey(origem) || !SIGLA_PARA_ID.containsKey(destino)) {
            System.out.println("Erro: Sigla inválida. Use apenas estados do Nordeste.");
            return;
        }

        int s = SIGLA_PARA_ID.get(origem);
        int d = SIGLA_PARA_ID.get(destino);

        DepthFirstPaths dfs = new DepthFirstPaths(G, s);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        System.out.println("\n========================================");
        System.out.println("RESULTADOS DAS BUSCAS");
        System.out.println("========================================");

        // Resposta Pergunta 1
        boolean possivel = dfs.hasPathTo(d);
        System.out.println("1. É possível sair de " + origem + " e chegar a " + destino + "?");
        System.out.println("   R: " + (possivel ? "Sim" : "Não"));

        if (possivel) {
            // Resposta Pergunta 2
            System.out.println("\n2. Qual caminho foi encontrado pela DFS de " + origem + " até " + destino + "?");
            System.out.print("   R: ");
            printPath(dfs.pathTo(d));

            // Resposta Pergunta 3
            System.out.println("\n3. Qual caminho foi encontrado pela BFS de " + origem + " até " + destino + "?");
            System.out.print("   R: ");
            printPath(bfs.pathTo(d));
        }

        // Resposta Pergunta 4
        System.out.println("\n4. Quais estados são alcançáveis a partir de " + origem + "?");
        System.out.print("   R: ");
        List<String> alcancaveis = new ArrayList<>();
        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                alcancaveis.add(ESTADOS[v]);
            }
        }
        System.out.println(String.join(", ", alcancaveis));

        // Resposta Pergunta 5
        System.out.println("\n5. Qual foi a ordem de visita na execução da DFS a partir de " + origem + "?");
        System.out.print("   R: ");
        printList(dfs.getVisitOrder());

        // Resposta Pergunta 6
        System.out.println("\n6. Qual foi a ordem de visita na execução da BFS a partir de " + origem + "?");
        System.out.print("   R: ");
        printList(bfs.getVisitOrder());
        
        input.close();
    }

    private static void printPath(Iterable<Integer> path) {
        List<String> siglas = new ArrayList<>();
        for (int v : path) siglas.add(ESTADOS[v]);
        System.out.println(String.join(" -> ", siglas));
    }

    private static void printList(List<Integer> list) {
        List<String> siglas = new ArrayList<>();
        for (int v : list) siglas.add(ESTADOS[v]);
        System.out.println(String.join(" -> ", siglas));
    }
}