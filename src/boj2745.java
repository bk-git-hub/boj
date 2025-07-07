import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int tmp = 1;
        int total = 0;
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            int r;
            if(c>='A'&&c<='Z'){
                r = 10 + (c-'A');
            } else {
                r = c-'0';
            }
            total += r*tmp;
            tmp *=B;
        }

        System.out.println(total);
    }
}
