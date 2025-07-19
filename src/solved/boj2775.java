package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        for(int i=0;i<15;i++){
            apt[i][1] = 1;
            apt[0][i] = i;
        }

        for(int i=1;i<15;i++){
            for(int j=1;j<15;j++){
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<t;i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            sb.append(apt[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}
