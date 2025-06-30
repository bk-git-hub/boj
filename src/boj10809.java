import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabets = new int[26];
        Arrays.fill(alphabets,-1);
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);

            if(alphabets[current-'a']== -1){
                alphabets[current-'a'] = i;
            }
        }

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(alphabets[i]).append(" ");
        }

        System.out.println(sb);
    }
}
