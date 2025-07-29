package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj6603 {
    static int N;
    static int[] arr;
    static int[] lotto;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            lotto = new int[N];
            if(N==0){
                break;
            }


            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            getCases(0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void getCases(int depth){
        if(depth == 6) {
            for(int i=0;i<6;i++){
                sb.append(lotto[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]&&depth==0 || lotto[depth-1]<arr[i]){
                lotto[depth] = arr[i];
                visited[i] =true;
                getCases(depth+1);
                visited[i] =false;
            }
        }
    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
///**
// * boj6603 - 로또 (Top-Tier-Style: Standard Combination Backtracking)
// * @author Gemini
// */
//public class Main {
//    static int k;
//    static int[] S;
//    static int[] combination = new int[6];
//    static StringBuilder sb;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        sb = new StringBuilder();
//
//        while (true) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            k = Integer.parseInt(st.nextToken());
//            if (k == 0) break;
//
//            S = new int[k];
//            for (int i = 0; i < k; i++) {
//                S[i] = Integer.parseInt(st.nextToken());
//            }
//
//            // 0번째 깊이부터, S배열의 0번 인덱스부터 탐색 시작
//            findCombinations(0, 0);
//            sb.append('\n');
//        }
//        System.out.print(sb);
//    }
//
//    /**
//     * 조합을 찾는 백트래킹 함수
//     * @param depth 현재 뽑은 숫자의 개수 (결과 배열의 인덱스)
//     * @param start 탐색을 시작할 S배열의 인덱스
//     */
//    private static void findCombinations(int depth, int start) {
//        // 베이스 케이스: 6개를 모두 뽑았다면
//        if (depth == 6) {
//            for (int val : combination) {
//                sb.append(val).append(' ');
//            }
//            sb.append('\n');
//            return;
//        }
//
//        // 재귀 단계: start 인덱스부터 k까지 탐색
//        for (int i = start; i < k; i++) {
//            combination[depth] = S[i];
//            // 다음 숫자는 현재 뽑은 숫자(i)의 다음 위치(i+1)부터 찾는다.
//            findCombinations(depth + 1, i + 1);
//        }
//    }
//}