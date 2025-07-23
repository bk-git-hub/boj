package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while(true){
            if(E==1 && S==1 && M==1) break;

            E--;
            S--;
            M--;
            if(E<1){
                E=15;
            }
            if(S<1){
                S=28;
            }
            if(M<1){
                M=19;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
