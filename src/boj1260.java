import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj1260 {
    static boolean[][] graph;
    static boolean[] visited;
    static int N;
    static int M;
    static int V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
            graph[to][from] = true;
        }

        dfs(V);
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs(V);
        System.out.print(sb);

    }

    private static void dfs(int from) {
        if (!visited[from]) {
            visited[from] = true;
            sb.append(from).append(' ');
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[from][i]) {
                dfs(i);
            }
        }

    }

    private static void bfs(int from) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(from);
        visited[from] = true;
        while (!queue.isEmpty()) {
            int cur = queue.pollLast();
            sb.append(cur).append(' ');
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[cur][i]) {
                    queue.push(i);
                    visited[i] = true;
                }
            }
        }

    }
}
