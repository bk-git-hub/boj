package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1107 {
    private static boolean[] isBroken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int currentChannel = 100;
        if(M>0){
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                int brokenButton = Integer.parseInt(st.nextToken());
                isBroken[brokenButton] = true;
            }
        }

        int  minPresses = Math.abs(N-100);
        for (int C = 0; C <= 999999; C++) {

            int presses = possiblePresses(C);

            if (presses > 0) {
                int totalPresses = presses + Math.abs(N - C);
                minPresses = Math.min(minPresses, totalPresses);
            }
        }

        System.out.println(minPresses);
    }

    private static int possiblePresses(int channel) {
        if(channel == 0){
            return isBroken[0]? 0:1;
        }
        int length = 0;
        while(channel>0){
            if(isBroken[channel%10]){
                return 0;
            }
            channel/=10;
            length++;
        }

        return length;
    }
}
