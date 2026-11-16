import java.io.*;
import java.util.*;

/*
 * SSAFY / SWEA 실전 템플릿
 *
 * 제출 전 체크
 *  1. package 줄 없음 (있으면 컴파일 에러)
 *  2. 클래스명: SWEA는 Solution, 백준은 Main
 *  3. System.setIn(...) 줄 주석 처리
 *  4. 테스트케이스마다 static 변수/배열 초기화 (min, max, cnt, visited ...)
 *  5. 출력 형식: "#번호 답" + 줄바꿈
 *
 * 아래 main은 예시 문제(격자 최단거리)를 푸는 코드다.
 *  입력: T / 각 TC마다 N M, 이어서 N줄의 격자 (0 = 길, 1 = 벽)
 *  출력: (0,0)에서 (N-1,M-1)까지 최소 이동 칸 수, 못 가면 -1
 */
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, M;
    static int[][] map;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    // 8방향 (오셀로, 오목 같은 문제): 상 하 좌 우 좌상 우상 좌하 우하
    static int[] dr8 = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc8 = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt")); // 로컬 테스트용. 제출 전에 주석!
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // ---- 여기서 TC마다 전부 새로 만든다 ----
            N = nextInt();
            M = nextInt();
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = nextInt();
                    // 격자가 "0110"처럼 붙어서 들어오면:
                    // String row = next(); map[i][j] = row.charAt(j) - '0';
                }
            }

            int answer = bfs(0, 0);

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }

    // 격자 BFS 최단거리. dist를 visited로 같이 쓴다 (-1 = 미방문)
    static int bfs(int sr, int sc) {
        if (map[sr][sc] == 1) return -1;
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == N - 1 && c == M - 1) return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!inRange(nr, nc)) continue;   // 범위 체크를 항상 먼저
                if (map[nr][nc] == 1) continue;
                if (dist[nr][nc] != -1) continue;
                dist[nr][nc] = dist[r][c] + 1;    // 넣을 때 방문 처리
                q.offer(new int[]{nr, nc});
            }
        }
        return -1;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    // 줄바꿈이 어디서 끊기든 토큰 단위로 읽는다 (입력 형식이 예상과 달라도 안전)
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
