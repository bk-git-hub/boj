package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class boj1406 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> leftStack = new ArrayDeque<>();
        Deque<Character> rightStack = new ArrayDeque<>();

        String initialStr = br.readLine();
        for (char ch : initialStr.toCharArray()) {
            leftStack.push(ch);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            switch (cmd) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(command.charAt(2));
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}