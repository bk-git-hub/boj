package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj10974 {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new int[N+1];
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth){
        if(depth==N){
           for(int i=0;i<N;i++){
               sb.append(arr[i]).append(' ');
           }
           sb.append('\n');
           return;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                arr[depth] = i;
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
