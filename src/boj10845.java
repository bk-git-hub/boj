import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer poppedItem = queue.poll();
                    if (poppedItem == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(poppedItem).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    Integer frontItem = queue.peek();
                    if (frontItem == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(frontItem).append('\n');
                    }
                    break;
                case "back":
                    Integer backItem = queue.peekLast();
                    if (backItem == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(backItem).append('\n');
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}