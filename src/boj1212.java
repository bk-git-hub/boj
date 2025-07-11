import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();

        // 0이 입력되는 엣지 케이스 처리
        if (octal.equals("0")) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();

        // 2. 두 번째 자릿수부터 사용할 매핑 테이블
        String[] octalToBinaryMap = {"000", "001", "010", "011", "100", "101", "110", "111"};

        // 1. 첫 자릿수는 내장 함수를 이용해 불필요한 앞자리 0 없이 처리
        int firstDigit = octal.charAt(0) - '0';
        sb.append(Integer.toBinaryString(firstDigit));

        // 3. 두 번째 자릿수부터는 매핑 테이블을 이용해 3자리를 꽉 채워 변환
        for (int i = 1; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';
            sb.append(octalToBinaryMap[digit]);
        }

        System.out.println(sb);
    }
}
