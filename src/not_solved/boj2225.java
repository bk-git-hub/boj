package not_solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MOD= 1_000_000_000;
        long [][] dp = new long[K+1][N+1];

        for(int n=0;n<=N;n++){
            dp[1][n] = 1;
        }

        for(int k=2;k<=K;k++){
            for(int n = 0; n<=N;n++){
                if(n==0){
                    dp[k][n] = 1;
                } else {
                    dp[k][n] = (dp[k-1][n] + dp[k][n-1])%MOD;
                }
            }
        }
        System.out.println(dp[K][N]);

    }
}
