package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj15649 {
    private static boolean[] visited;
    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited= new boolean[N+1];
        sb = new StringBuilder();
        f = new int[M];

        build(0);
        System.out.println(sb);
    }

    public static void build(int cnt){
        if(cnt == M ){
            for(int it = 0 ; it < M;it++){
                sb.append(f[it]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i] = true;
                f[cnt]= i;
                build(cnt+1);
                visited[i] = false;
            }
        }
    }

}
