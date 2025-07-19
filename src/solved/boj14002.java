package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int maxLength = 0;

        for (int len : dp) {
            if (len > maxLength) {
                maxLength = len;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxLength).append('\n');

        Deque<Integer> lis = new ArrayDeque<>();


        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == maxLength) {
                if (lis.isEmpty() || arr[i] < lis.peek()) {
                    lis.push(arr[i]);
                    maxLength--;
                }
            }
        }

        while (!lis.isEmpty()) {
            sb.append(lis.pop()).append(' ');
        }

        System.out.println(sb);
    }
}
