import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class boj17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean inTag = false;
        for(char c: S.toCharArray()){
            if(c == '<'){
                printStack(sb,stack);
                sb.append(c);
                inTag = true;
            }else if(c == '>'){
                sb.append(c);
                inTag = false;
            }else if(inTag) {
                sb.append(c);
            } else if(c == ' ') {
                printStack(sb,stack);
                sb.append(c);
            } else{
                stack.push(c);
            }
        }
        printStack(sb,stack);
        System.out.println(sb);
    }

    public static void printStack(StringBuilder sb ,Deque<Character> stack){
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

    }
}
