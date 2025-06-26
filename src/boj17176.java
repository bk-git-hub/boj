import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj17176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] alphabets = new char[54];
        int[] plainCounts = new int[54];
        int[] codeCounts = new int[54];
        alphabets[0] = ' ';

        for(int i=1;i<=26;i++){
            alphabets[i] = (char)('A'+i-1);
            alphabets[26+i] = (char)('a'+i-1);
        }

        int N = Integer.parseInt(br.readLine());
        String code = br.readLine();
        String plainText = br.readLine();
        StringTokenizer st = new StringTokenizer(code);

        while(st.hasMoreTokens()){
            int codeNum = Integer.parseInt(st.nextToken());
            codeCounts[codeNum]++;
        }

        for(char c:plainText.toCharArray()){
            if(c>='a'&& c<='z'){
                plainCounts[c-'a'+27] ++;
            } else if(c>='A' && c<='Z'){
                plainCounts[c-'A'+1]++;
            } else if(c==' '){
                plainCounts[0]++;
            }
        }
        for(int i=0;i<54;i++){
            if(codeCounts[i]!= plainCounts[i]){
                System.out.println("n");
                return;
            }
        }

        System.out.println("y");
    }
}
