import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octalDigit = br.readLine();

        int len = octalDigit.length();
        StringBuilder sb = new StringBuilder();
        int first = octalDigit.charAt(0)-'0';
        if(first>=4){
            sb.append(1);
        }

        if(first%4>=2 && first>=2){
            sb.append(1);
        } else {
            sb.append(0);
        }

        if(first%2 ==1) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        for(int i=1;i<len;i++){
            int cur = octalDigit.charAt(i)-'0';
            if(cur>=4){
                sb.append(1);
            }else {
                sb.append(0);
            }
            if(cur%4>=2){
                sb.append(1);
            } else {
                sb.append(0);
            }
            if(cur%2 ==1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        System.out.println(sb);
    }
}
