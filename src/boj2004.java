import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long countFive = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);
        long countTwo = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);

        System.out.println(Math.min(countFive, countTwo));
    }

    private static long countFactors(long num, int prime) {
        long count = 0;
        for (long i = prime; i <= num; i *= prime) {
            count += num / i;
        }
        return count;
    }
}