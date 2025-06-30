import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        while(true){
            if(N>=100) {
                return;
            }
            String s = br.readLine();
            if(s == null|| s.length()<1){
                return;
            }
            int lowerCnt = 0;
            int upperCnt = 0;
            int spaceCnt = 0;
            int numCnt = 0;

            for(char c:s.toCharArray()){
                if(c>='a' && c<='z'){
                    lowerCnt++;
                }
                else if(c>='A'&&c<='Z'){
                    upperCnt++;
                }
                else if(c>='0'&&c<='9'){
                    numCnt++;
                }
                else if(c==' '){
                    spaceCnt++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(lowerCnt).append(" ").append(upperCnt).append(" ").append(numCnt).append(" ").append(spaceCnt).append("\n");
            System.out.print(sb);
            N++;
        }
    }
}
