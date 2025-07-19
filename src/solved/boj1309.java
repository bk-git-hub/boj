package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 9901;
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long [N+1][2];
        dp[1][0] = 1;  //끝열에 사자가 없는 경우
        dp[1][1] = 2;  //끝열에 사자가 하나 있는경우

        for(int i=2;i<=N;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1])%MOD;
            dp[i][1] = (2*dp[i-1][0] + dp[i-1][1])%MOD;
        }

        System.out.println((dp[N][0]+dp[N][1])%MOD);
    }
}
