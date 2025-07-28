package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj10973 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        if(findPrev(arr)){
            for(int i=0;i<N;i++){
                sb.append(arr[i]).append(' ');
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    private static boolean findPrev(int[] arr){
        int i=N-1;
        while(i>=1 && arr[i]>arr[i-1]){
            i--;
        }
        if(i<=0){
            return false;
        }

        int j = N-1;
        while (arr[j]>=arr[i-1]){
            j--;
        }

        swap(arr,i-1,j);
        j = N - 1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
        return true;
    }
    private static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
