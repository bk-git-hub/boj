package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabets = new int[26];
        for(char c:word.toCharArray()){
            alphabets[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<26;i++){
            sb.append(alphabets[i]).append(" ");
        }

        System.out.println(sb);
    }
}
