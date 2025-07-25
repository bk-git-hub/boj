package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];
        for(int i=1;i<10;i++){
            dp[1][i] = 1;
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<10;j++){
                if(j>0) dp[i][j]+= dp[i-1][j-1];
                if(j<9) dp[i][j]+= dp[i-1][j+1];

                dp[i][j] %= 1000000000;
            }
        }
        int total = 0;
        for(int i=0;i<10;i++){
            total+= dp[N][i];
        }
        System.out.println(total);

    }
}
