package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj15661 {
    static int N;
    static int[][] S;
    static boolean[] isTeam1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            isTeam1 = new boolean[N];
            findCombination(0, 0, i);
        }
        System.out.println(min);
    }

    public static void findCombination(int depth, int start, int count) {
        if (depth == count) {

            getDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            isTeam1[i] = true;
            findCombination(depth + 1, i + 1, count);
            isTeam1[i] = false;
        }
    }

    public static void getDiff() {
        int total1 = 0;
        int total2 = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isTeam1[i] && isTeam1[j]) {

                    total1 += S[i][j];
                    total1 += S[j][i];
                } else if (!isTeam1[i] && !isTeam1[j]) {

                    total2 += S[i][j];
                    total2 += S[j][i];
                }
            }
        }


        if (min > Math.abs(total1 - total2)) {
            min = Math.abs(total1 - total2);


        }

    }
}
