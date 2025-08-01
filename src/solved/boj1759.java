package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj1759 {
    static int L, C;
    static char[] chars;
    static char[] password;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        findPasswords(0, 0);

        System.out.print(sb);
    }

    private static void findPasswords(int depth, int start) {
        if (depth == L) {
            if (isValid(password)) {
                sb.append(password).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            password[depth] = chars[i];
            findPasswords(depth + 1, i + 1);
        }
    }

    private static boolean isValid(char[] pass) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char c : pass) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return vowelCount >= 1 && consonantCount >= 2;
    }
}