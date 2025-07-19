package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] A = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] nge= new int[N];
        Arrays.fill(nge,-1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && A[stack.peek()]<A[i]){
                nge[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int val : nge) {
            sb.append(val).append(' ');
        }
        System.out.println(sb);

    }
}
