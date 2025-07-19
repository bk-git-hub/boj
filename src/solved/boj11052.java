package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            prices[i] = Integer.parseInt(st.nextToken());
            for(int j=1;j<i;j++){
                prices[i] = Math.max(prices[j]+prices[i-j],prices[i]);
            }
        }

        System.out.println(prices[N]);

    }
}
