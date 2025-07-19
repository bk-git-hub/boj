package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj29196 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String kStr = br.readLine();
        String decimalPart = kStr.substring(2);
        long p = Long.parseLong(decimalPart);
        long q = 1;

        for(int i=0;i<decimalPart.length();i++){
            q*=10;
        }

        long commonDivisor = gcd(p,q);

        p /=commonDivisor;
        q /= commonDivisor;

        System.out.println("YES");
        System.out.println(p + " " + q);
    }
    private static long gcd(long a, long b){
        if(b==0) {
            return a;
        }
        return gcd(b,a%b);
    }
}
