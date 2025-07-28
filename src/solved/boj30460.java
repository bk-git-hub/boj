package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj30460 {
    static int N;
    static int[] A;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new int[N+1][4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int minVal = Integer.MIN_VALUE;
        dp[1][0] = minVal;
        dp[1][1] = minVal;
        dp[1][2] = 2*A[1];
        dp[1][3] = A[1];

        dp[2][0] = minVal;
        dp[2][1] = 2*A[1] + 2*A[2];
        dp[2][2] = A[1] + 2*A[2];
        dp[2][3] = A[1] + A[2];


        for(int i=3;i<=N;i++){
            //T+2일때
            dp[i][0] = 2*A[i] + dp[i-1][1];
            //T+1일때
            dp[i][1] = 2*A[i] + dp[i-1][2];
            //T 일때
            dp[i][2] = 2*A[i] + Math.max(dp[i-1][0],dp[i-1][3]);
            //안누를때
            dp[i][3] = A[i] + Math.max(dp[i-1][0], dp[i-1][3]);
        }


        int max = Integer.MIN_VALUE;
        for(int i=0;i<4;i++){
            if(dp[N][i]>max){
                max = dp[N][i];
            }
        }

        System.out.println(max);
    }
}
