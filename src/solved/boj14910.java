package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj14910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isGood = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int initialNum = Integer.parseInt(st.nextToken());
        int curNum = initialNum;
        while(st.hasMoreTokens()){
            int nextNum = Integer.parseInt(st.nextToken());
            if(curNum> nextNum){
                isGood = false;
                break;
            }
            curNum = nextNum;
        }

        String result = isGood ? "Good" : "Bad";
        System.out.println(result);
    }
}
