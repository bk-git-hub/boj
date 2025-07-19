package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj26209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<8;i++){
            String bit = st.nextToken();
            if(bit.equals("9")){
                System.out.print("F");
                return;
            }
        }
        System.out.print("S");
    }
}
