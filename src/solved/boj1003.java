package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1003 {
    static int[] zeroCnt = new int[41];
    static int[] oneCnt = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        zeroCnt[0] = 1;
        zeroCnt[1] = 0;
        oneCnt[0] = 0;
        oneCnt[1] = 1;

        for(int i=2;i<=40;i++){
            zeroCnt[i] = zeroCnt[i-1]+ zeroCnt[i-2];
            oneCnt[i] = oneCnt[i-1] + oneCnt[i-2];
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(zeroCnt[N]).append(" ").append(oneCnt[N]).append('\n');
        }

        System.out.print(sb);
    }

}
