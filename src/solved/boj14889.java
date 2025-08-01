package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj14889 {
    static int N;
    static int[][] S;
    static int min = Integer.MAX_VALUE;
    static int[] T1;
    static int[] T2;
    static boolean[] picked;
    static int players;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        picked = new boolean[N];
        players = N / 2;
        T1 = new int[players];
        T2 = new int[players];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickPlayer(0, 0);
        System.out.println(min);
    }

    public static void pickPlayer(int start, int cnt) {
        if (cnt == players) {
            int t2 = 0;
            for (int i = 0; i < N; i++) {
                if (!picked[i]) {
                    T2[t2++] = i;
                }
            }
            int diff = getDiff();
            if (min > diff) {
                min = diff;
            }
            T2 = new int[players];
            return;
        }
        for (int i = start; i < N; i++) {
            if (!picked[i]) {
                picked[i] = true;
                T1[cnt] = i;
                pickPlayer(i + 1, cnt + 1);
                picked[i] = false;
            }
        }
    }

    public static int getDiff() {
        return Math.abs(getTeamStat(T1) - getTeamStat(T2));
    }

    public static int getTeamStat(int[] T) {
        int total = 0;
        for (int i = 0; i < players - 1; i++) {
            for (int j = i + 1; j < players; j++) {
                total += S[T[i]][T[j]];
                total += S[T[j]][T[i]];
            }
        }

        return total;
    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//    static int N;
//    static int[][] S;
//    static boolean[] isInStartTeam; // 'picked' 대신 의미가 명확한 이름
//    static int minDiff = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        S = new int[N][N];
//        isInStartTeam = new boolean[N];
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                S[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 0번 선수는 스타트팀으로 고정하고, 1번 선수부터 나머지 N/2 - 1명을 뽑는다.
//        findCombinations(0, 0);
//
//        System.out.println(minDiff);
//    }
//
//    /**
//     * 스타트팀에 속할 N/2명의 조합을 찾는 백트래킹 함수
//     * @param start 탐색을 시작할 선수의 번호
//     * @param depth 현재까지 뽑은 스타트팀 선수의 수
//     */
//    public static void findCombinations(int start, int depth) {
//        // 베이스 케이스: N/2명의 팀원 구성이 완료되면
//        if (depth == N / 2) {
//            calculateDiff();
//            return;
//        }
//
//        for (int i = start; i < N; i++) {
//            isInStartTeam[i] = true;
//            findCombinations(i + 1, depth + 1);
//            isInStartTeam[i] = false; // 백트래킹
//        }
//    }
//
//    // 두 팀의 능력치 차이를 계산하는 함수
//    public static void calculateDiff() {
//        int startTeamStat = 0;
//        int linkTeamStat = 0;
//
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = i + 1; j < N; j++) {
//                // i번과 j번 선수가 모두 스타트팀이라면
//                if (isInStartTeam[i] && isInStartTeam[j]) {
//                    startTeamStat += S[i][j] + S[j][i];
//                }
//                // i번과 j번 선수가 모두 링크팀이라면
//                else if (!isInStartTeam[i] && !isInStartTeam[j]) {
//                    linkTeamStat += S[i][j] + S[j][i];
//                }
//            }
//        }
//
//        minDiff = Math.min(minDiff, Math.abs(startTeamStat - linkTeamStat));
//    }
//}