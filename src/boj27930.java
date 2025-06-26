import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class boj27930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> korea = new ArrayDeque<>();
        Deque<Character> yonsei = new ArrayDeque<>();

        String k = "KOREA";
        String y = "YONSEI";

        for(char c:k.toCharArray()){
            korea.push(c);
        }
        for(char c:y.toCharArray()){
            yonsei.push(c);
        }

        String fortune = br.readLine();

        for(char c:fortune.toCharArray()){
            if(korea.getLast() == c){
                korea.pollLast();
            }
            if(yonsei.getLast()==c){
                yonsei.pollLast();
            }

            if(korea.isEmpty()){
                System.out.print("KOREA");
                return;
            }
            if(yonsei.isEmpty()){
                System.out.print("YONSEI");
                return;
            }
        }

    }
}
