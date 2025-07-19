package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.empty()).append('\n');
                    break;
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    public static class Stack {

        private ArrayList<Integer> list;

        public Stack(){
            list = new ArrayList<>();
        }
        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            if(list.isEmpty()){
                return -1;
            }
            return list.remove(list.size()-1);
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            return list.isEmpty() ? 1:0;
        }

        public int top() {
            if(list.isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }


}
