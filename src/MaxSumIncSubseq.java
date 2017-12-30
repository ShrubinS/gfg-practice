import java.util.*;

public class MaxSumIncSubseq {


    private static int getMaxSumIncSub(int[] arr, int n) {
        int gMax = 0;
        int lMax = 0;
        int prev = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] > prev) {
                lMax += arr[i];
            }

            prev = arr[i];
        }
    }

    public static void main (String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(getMaxSumIncSub(arr, n));
        }
        in.close();
    }
}