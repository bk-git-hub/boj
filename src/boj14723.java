import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj14723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int diagonal = 1;
        while(N>diagonal){
            N -= diagonal;
            diagonal++;
        }

        int numerator;
        int denominator;

            numerator = diagonal - N + 1;
            denominator = N;

        System.out.println(numerator + " " + denominator);
    }
}
