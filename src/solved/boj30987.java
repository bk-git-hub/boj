package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj30987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());


        long result = H(x2, a, b, c, d, e) - H(x1, a, b, c, d, e);

        System.out.println(result);
    }

    private static long H(int x, int a, int b, int c, int d, int e) {
        long x_l = x; // 연산 시 long 타입으로 자동 형변환을 유도하기 위함

        long term3 = (long)(a / 3) * x_l * x_l * x_l;
        long term2 = (long)((b - d) / 2) * x_l * x_l;
        long term1 = (long)(c - e) * x_l;

        return term3 + term2 + term1;
    }
}
