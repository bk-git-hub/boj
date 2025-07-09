import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int remainder = binary.length()%3;
        StringBuilder sb = new StringBuilder();

        if(remainder == 1){
            sb.append(binary.charAt(0));
        } else if(remainder == 2) {
            int firstGroup = (binary.charAt(0) - '0') * 2 + (binary.charAt(1) - '0');
            sb.append(firstGroup);
        }

        for (int i = remainder; i < binary.length(); i += 3) {
            // "110" -> (1*4) + (1*2) + (0*1) = 6
            int octalDigit = (binary.charAt(i) - '0') * 4
                    + (binary.charAt(i + 1) - '0') * 2
                    + (binary.charAt(i + 2) - '0');
            sb.append(octalDigit);
        }
        System.out.println(sb);
    }
}
