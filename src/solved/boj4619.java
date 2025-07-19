package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj4619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){

            String line = br.readLine();
            if(line == null || line.equals("0 0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(line);

            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int a1 = (int) Math.pow(B, 1.0 / N);
            int a2 = a1 + 1;

            long diff1 = Math.abs(B - (long) Math.pow(a1, N));
            long diff2 = Math.abs(B - (long) Math.pow(a2, N));

            int result = (diff1 <= diff2) ? a1 : a2;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
