package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int[] counts = new int[26];
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            counts[c - 'A']++;
        }

        int oddCount = 0;
        char midChar = 0;

        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('A' + i);
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            for (int j = 0; j < counts[i] / 2; j++) {
                sb.append(c);
            }
        }

        if (oddCount == 1) {
            sb.append(midChar);
        }

        for (int i = 25; i >= 0; i--) {
            char c = (char) ('A' + i);
            for (int j = 0; j < counts[i] / 2; j++) {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
