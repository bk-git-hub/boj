package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n==0){
            System.out.println(0);
            return;
        }
        int[] rates = new int[n];
        for(int i=0;i<n;i++){
            rates[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rates);

        int cutoff = (int) Math.round(n*0.15);
        double total = 0;
        for(int i=cutoff;i<n-cutoff;i++){
            total += rates[i];
        }
        int count = n - (cutoff * 2);

        System.out.println(Math.round(total/count));

    }
}
