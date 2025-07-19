package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isNotPrime = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int MAX = 1000000;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i=2;i<=MAX;i++){
            if(checkPrime(i)){
                for(int j=i+i;j<=MAX;j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=M;i<=N;i++){
            if(!isNotPrime[i]){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);

    }

    public static boolean checkPrime(int n){
        for(int i=2;i*i<n;i++){
            if(n%i ==0 ){
                return false;
            }
        }
        return true;
    }
}


