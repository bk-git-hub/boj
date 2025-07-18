package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(N>0){
            int remainder = N%B;
            if (remainder >= 10) {
                sb.append((char) ('A' + (remainder - 10)));
            } else {
                sb.append(remainder);
            }
            N/=B;
        }

        System.out.println(sb.reverse());
    }
}
