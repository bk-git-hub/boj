package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj15665 {
    static int N, M;
    static int[] numbers;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        visited = new boolean[N];
        numbers = new int[N];
        result = new int[M];

        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs( int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int prevNum = 0;
        for(int i=0;i<N;i++){
            if(prevNum != numbers[i]){
                result[depth] = numbers[i];
                prevNum = numbers[i];
                dfs(depth+1);
            }
        }
    }
}


