package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int prevR = 0, prevG = 0, prevB = 0;
        StringTokenizer initst = new StringTokenizer(br.readLine());
        int initR = Integer.parseInt(initst.nextToken());
        int initG = Integer.parseInt(initst.nextToken());
        int initB = Integer.parseInt(initst.nextToken());


        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int costR = Integer.parseInt(st.nextToken());
            int costG = Integer.parseInt(st.nextToken());
            int costB = Integer.parseInt(st.nextToken());

            int currentR = costR + Math.min(prevG, prevB);
            int currentG = costG + Math.min(prevR, prevB);
            int currentB = costB + Math.min(prevR, prevG);

            prevR = currentR;
            prevG = currentG;
            prevB = currentB;
            StringBuilder sb = new StringBuilder();

        }
        int[] total = new int[6];
        total[0] = initR + prevG;
        total[1] = initR + prevB;
        total[2] = initG + prevR;
        total[3] = initG + prevB;
        total[4] = initB + prevR;
        total[5] = initB + prevG;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (total[i] < min) {
                min = total[i];
            }
        }

        System.out.println(min);
    }
}