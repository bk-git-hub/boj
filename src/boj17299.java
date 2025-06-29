import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] counts = new int[1000001];
        int[] FA = new int[N];
        int[] NGF = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.fill(NGF,-1);
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
            counts[A[i]]++;
        }

        for(int i=0;i<N;i++){
            FA[i] = counts[A[i]];
        }

        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && FA[stack.peek()]<FA[i]){
                NGF[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(NGF[i]).append(" ");
        }

        System.out.println(sb);
    }
}
