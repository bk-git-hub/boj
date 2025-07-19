package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 10007;
        int N = Integer.parseInt(br.readLine());
        long[] prevdp = new long[10];
        for(int i=0;i<10;i++){
            prevdp[i] = 1;
        }
        long[] dp = new long[10];

        for(int i=1;i<N;i++){
           for(int j=0;j<10;j++){
               dp[j] = 0;
               for(int k=0;k<=j;k++){
                   dp[j] += prevdp[k];
                   dp[j] %=MOD;
               }
           }
           for(int j=0;j<10;j++){
               prevdp[j] = dp[j];
           }
        }
        int total = 0;
        for(int i=0;i<10;i++){
            total += prevdp[i];
        }


        System.out.println(total%MOD);
    }
}
