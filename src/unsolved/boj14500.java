package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj14500 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int max = 0;
    // 상, 하, 좌, 우 이동
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸에 대해 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1. DFS로 'ㅜ'를 제외한 모양들 탐색
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;

                // 2. 'ㅜ' 모양은 별도로 탐색
                checkTShape(i, j);
            }
        }

        System.out.println(max);
    }

    /**
     * 'ㅜ' 모양을 제외한 나머지 모양을 탐색하는 DFS 함수
     *
     * @param r     현재 행
     * @param c     현재 열
     * @param depth 현재까지 방문한 칸의 수
     * @param sum   현재까지의 합
     */
    private static void dfs(int r, int c, int depth, int sum) {
        // 4개의 칸을 모두 방문했으면 최댓값 갱신 후 종료
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 인접 칸으로 이동
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 보드 범위를 벗어나거나 이미 방문한 칸이면 건너뜀
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc, depth + 1, sum + board[nr][nc]);
            visited[nr][nc] = false; // 백트래킹
        }
    }

    /**
     * 'ㅜ' 모양 4가지 방향을 모두 체크하는 함수
     *
     * @param r 중심 칸의 행
     * @param c 중심 칸의 열
     */
    private static void checkTShape(int r, int c) {
        // 4개의 날개(상,하,좌,우) 중 3개를 선택하는 모든 경우를 확인
        int wings = 4;
        for (int i = 0; i < wings; i++) {
            int sum = board[r][c];
            boolean isPossible = true;
            // 날개 3개 조합
            for (int j = 0; j < wings - 1; j++) {
                int wingIndex = (i + j) % wings;
                int nr = r + dr[wingIndex];
                int nc = c + dc[wingIndex];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    isPossible = false;
                    break;
                }
                sum += board[nr][nc];
            }
            if (isPossible) {
                max = Math.max(max, sum);
            }
        }
    }
}