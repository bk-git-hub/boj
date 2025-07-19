package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        Integer i = 0;
        while(true){
            if(cnt==N){
                break;
            }
            i++;
            String str = i.toString();
            if(str.contains("666")){
                cnt++;
            }

        }

        System.out.println(i);

    }
}
