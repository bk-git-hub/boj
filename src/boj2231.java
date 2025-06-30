import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int t = N;
        while(t>0){
            cnt++;
            t/=10;
        }
        int minimum = N-cnt*9 >0 ? N-cnt*9 : 1;

        int result = 0;

        for (int M = minimum; M < N; M++) {
            int sumOfDigits = 0;
            int number = M;

            while (number != 0) {
                sumOfDigits += number % 10;
                number /= 10;
            }

            if (M + sumOfDigits == N) {
                result = M;
                break;
            }
        }

        System.out.println(result);
    }
}