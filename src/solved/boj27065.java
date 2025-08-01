package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj27065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[5000];
            arr[0] = 1;
            int divCount = getDivisors(arr,N);
            int total = 0;
            boolean isAnyAbundant = false;
            for(int i=0;i<divCount;i++){
                total += arr[i];
                isAnyAbundant = checkAbundantNumber(arr[i]);
                if(isAnyAbundant) break;
            }

            if(total>N && !isAnyAbundant){
                sb.append("Good Bye\n");
            } else {
                sb.append("BOJ 2022\n");
            }
        }

        System.out.print(sb);
    }

    private static int getDivisors(int[] arr, int n){
        int cnt = 1;
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
               arr[cnt++] = i;
               if(i!=n/i){
                   arr[cnt++] = n/i;
               }
            }
        }
        return cnt;
    }

    private static boolean checkAbundantNumber(int n) {
        int total = 1;
        for(int i=2;i*i<=n;i++){
            if(n%i ==0 ){
                total +=i;
                if(i!=n/i){
                    total += n/i;
                }
            }
        }
        return total>n;
    }
}
