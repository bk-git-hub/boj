package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Character> queue = new ArrayDeque<>();
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        n1.append(st.nextToken()).append(st.nextToken());
        n2.append(st.nextToken()).append(st.nextToken());



        BigInteger b1 = new BigInteger(n1.toString());
        BigInteger b2 = new BigInteger(n2.toString());



        System.out.println( b1.add(b2));
    }
}
