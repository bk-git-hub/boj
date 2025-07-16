import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                int jSquare = j*j;
                dp[i] = Math.min(dp[i],dp[i-jSquare]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
