package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj1874 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int currentNum = 1;

        for(int i=0;i<n;i++){
            int target = Integer.parseInt(br.readLine());
            while(currentNum<=target){
                stack.push(currentNum);
                sb.append("+\n");
                currentNum++;
            }

            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);

    }
}
