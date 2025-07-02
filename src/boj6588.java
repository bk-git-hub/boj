import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj6588 {
    public static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean[] isNotPrime = new boolean[MAX];
       isNotPrime[0] = isNotPrime[1] = true;

       for(int i=2;i*i<MAX;i++){
           if(!isNotPrime[i]){
               for(int j=i*i;j<MAX;j+=i){
                   isNotPrime[j] = true;
               }
           }
       }

       StringBuilder sb = new StringBuilder();

       while(true) {
           int n = Integer.parseInt(br.readLine());
           if (n == 0) {
               break;
           }
           boolean found  = false;
           for (int a = 3; a <= n / 2; a += 2) {
               if (!isNotPrime[a] && !isNotPrime[n - a]) {
                   sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append('\n');
                   found = true;
                   break;
               }
           }

           if (!found) {
               sb.append("Goldbach's conjecture is wrong.\n");
           }
       }
    }
}
