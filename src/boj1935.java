import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class boj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        double[] values = new double[N];
        Deque<Double> stack = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            values[i] = Double.parseDouble(br.readLine());
        }


        for(char c:exp.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                stack.push(values[c - 'A']);
                continue;
            }
            double a = stack.pop();
            double b = stack.pop();
            switch (c) {
                case '*':
                    stack.push(b * a);
                    break;
                case '/':
                    stack.push(b / a);
                    break;
                case '+':
                    stack.push(b + a);
                    break;
                case '-':
                    stack.push(b - a);
                    break;

            }
        }

        String result = String.format("%.2f" ,stack.pop());
        System.out.println(result);
    }
}
