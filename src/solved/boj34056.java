package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj34056 {
    static int N;
    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            D[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            if(action == 1){
                int leftWall = Integer.parseInt(st.nextToken())-1;
                int rightWall = leftWall + 1;
                int remainingSound = Integer.parseInt(st.nextToken());
                processConcert(leftWall, rightWall, remainingSound, remainingSound);

            } else if(action == 2){
                int checkingWall = Integer.parseInt(st.nextToken());
                sb.append(D[checkingWall-1]).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void processConcert(int leftWall, int rightWall, int leftRemainingSound, int rightRemainingSound){


        int curLeft = leftWall;
        while(curLeft>=0 && leftRemainingSound>0){
            long absorb = Math.min(D[curLeft], leftRemainingSound);
            leftRemainingSound -= absorb;
            D[curLeft] += absorb;
            curLeft --;
        }
        int curRight = rightWall;
        while(curRight<=N-1 && rightRemainingSound>0){
            long absorb = Math.min(D[curRight],rightRemainingSound);
            rightRemainingSound -= absorb;
            D[curRight] += absorb;
            curRight++;
        }
    }
}
