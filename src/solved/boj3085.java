package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085 {
    static int N;
    static char[][] board;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                checkBoard();
                swap(i, j, i, j + 1);
            }
        }


        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                checkBoard();
                swap(i, j, i + 1, j);
            }
        }

        System.out.println(maxCount);
    }


    private static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }


    private static void checkBoard() {

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }


        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
                if (board[i][j] == board[i + 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
    }
}