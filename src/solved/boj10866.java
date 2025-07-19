package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = 0;
            if(st.hasMoreTokens()){
                value = Integer.parseInt(st.nextToken());
            }
            Integer p;

            switch (command) {
                case "push_front":
                    deque.addFirst(value);
                    break;
                case "push_back":
                    deque.addLast(value);
                    break;
                case "pop_front":
                    p = deque.pollFirst();
                    if(p==null){
                        sb.append("-1\n");
                    } else {
                        sb.append(p).append("\n");
                    }

                    break;
                case "pop_back":
                    p = deque.pollLast();
                    if(p==null){
                            sb.append("-1\n");
                    } else {
                        sb.append(p).append("\n");
                    }
                    break;
                case "size":
                    int size = deque.size();
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append(1);
                    }else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    p = deque.peekFirst();
                    if(p==null){
                        sb.append("-1\n");
                    } else {
                        sb.append(p).append("\n");
                    }

                    break;

                case "back":
                    p = deque.peekLast();
                    if(p==null){
                        sb.append("-1\n");
                    } else {
                        sb.append(p).append("\n");
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
        System.out.print(sb);
    }
}
