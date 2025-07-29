package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj10971 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            tsp(i,i,0,0);
        }

        System.out.println(min);
    }

    private static void tsp(int startPos, int curPos, int visitCount, int distance){
        if(visitCount == N && curPos == startPos){
            if(min>distance){
                min = distance;
            }
        }

        for(int i=0;i<N;i++){
            if(map[curPos][i]!=0 && !visited[i]){
                visited[i] = true;
                tsp(startPos, i,visitCount+1,distance+map[curPos][i]);
                visited[i] = false;
            }
        }

    }
}
