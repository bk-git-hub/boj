import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class boj1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(char c:exp.toCharArray()){
            if(c>='A' && c<='Z'){
                sb.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while(!stack.isEmpty() && precedence(stack.peek())>= precedence(c)){
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);


    }

    public static int precedence(char op){
        if (op == '*' || op == '/') {
            return 2;
        } else if (op == '+' || op == '-') {
            return 1;
        } else if (op == '(') {
            return 0; // 괄호는 우선순위가 가장 낮음
        }
        return -1; // 에러 (나오지 않아야 함)
    }
}
