import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            sb.append(solve(br.readLine()));
            if(i<T-1) sb.append("\n");
        }

        System.out.print(sb);
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";

    }
}
