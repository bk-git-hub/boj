import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int openSticks= 0;
        int totalPieces = 0;

        String s = br.readLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
              openSticks++;
            } else {
                openSticks--;
                if(s.charAt(i-1) == '('){
                    totalPieces += openSticks;
                } else{
                    totalPieces += 1;
                }
            }

        }
        System.out.println(totalPieces);
    }
}
