import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i=0;i<T;i++){
            String[] words = br.readLine().split(" ");
            StringBuilder lineResult = new StringBuilder();
            for(int j=0;j<words.length;j++){
                String word = words[j];
                StringBuilder reverseWord = new StringBuilder(word);
                reverseWord.reverse();
                lineResult.append(reverseWord);
                if(j<words.length-1) lineResult.append(" ");
            }
            result.append(lineResult).append("\n");
        }

        System.out.print(result);

    }
}
