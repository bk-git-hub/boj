package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            if(binarySearch(A,target)){
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);

    }
    private static boolean binarySearch(int[] arr ,int target){
        int low = 0;
        int high = arr.length -1;

        while(low<=high){
            int mid = (low + high) /2;
            if(arr[mid] == target) {
                return true;
            }else if(arr[mid]<target){
                low = mid+1;
            }else {
                high = mid-1;
            }

        }
        return false;
    }
}
