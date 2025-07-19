package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int currentSibling = Integer.parseInt(st.nextToken());
        int D = Math.abs(S-currentSibling);

        for(int i=1;i<N;i++){
            currentSibling = Integer.parseInt(st.nextToken());
            int dist = Math.abs(S-currentSibling);
            D = gcd(D,dist);
        }

        System.out.println(D);
    }

    public static int gcd(int a, int b){
        if(b%a ==0 ){
            return  a;
        } else {
            return gcd(b, a%b);
        }
    }
}
