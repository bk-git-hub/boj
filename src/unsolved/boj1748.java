package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long cnt = 0;

        cnt += Math.min(N, 9);
        cnt += Math.max(0, Math.min((N - 9) * 2, 2 * 90)); //10-100
        cnt += Math.max(0, Math.min((N - 99) * 3, 3 * 900));//100 - 1000
        cnt += Math.max(0, Math.min((N - 999) * 4, 4 * 9000));//1000 - 10000
        cnt += Math.max(0, Math.min((N - 9999) * 5, 5 * 90000));//10000-100000
        cnt += Math.max(0, Math.min((N - 99999) * 6, 6 * 900000));//100000-1000000
        cnt += Math.max(0, Math.min((N - 999999) * 7, 7 * 9000000));//1000000-10000000
        cnt += Math.max(0, Math.min((N - 9999999) * 8, 8 * 90000000));//10000000-100000000

        System.out.println(cnt);
    }
}
