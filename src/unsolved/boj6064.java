package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 달력의 마지막 해 = M과 N의 최소공배수
            int lcm = M * N / gcd(M, N);
            int result = -1;

            // x부터 시작해서 M씩 건너뛰며 y가 맞는지 확인
            for (int k = x; k <= lcm; k += M) {
                if ((k - 1) % N + 1 == y) {
                    result = k;
                    break;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}