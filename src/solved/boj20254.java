package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ur = Integer.parseInt(st.nextToken());
        int tr = Integer.parseInt(st.nextToken());
        int uo = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.print(ur*56+tr*24+uo*14+to*6);


    }
}
