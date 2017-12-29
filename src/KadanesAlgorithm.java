import java.util.*;
import java.lang.*;
import java.io.*;

class KadanesAlgorithm {


    private static int contiguousSubArray(int[] arr, int n) {


        /*
            Easier way to write
            This is Kadane's Algorithm
            gfg -> 0.34 sec
         */
        int gMax = arr[0];
        int curMax = arr[0];
        for (int i=1; i<n; i++) {
            curMax = Math.max(arr[i], arr[i] + curMax);
            gMax = Math.max(curMax, gMax);
        }
        return gMax;

        /*
            Below does similar, just lot of repeated checks
            performance is better, somehow, maybe because of max check each time
            gfg -> 0.3 sec

            for (int i=1; i<n; i++) {
            if (arr[i] >= 0) {
                if (curMax >= 0) {
                    curMax += arr[i];
                } else {
                    curMax = arr[i];
                }
            } else {
                if (curMax > gMax) {
                    gMax = curMax;
                }
                if (curMax > 0) {
                    curMax += arr[i];
                }
                if (curMax < arr[i]) {
                    curMax = arr[i];
                }
            }
        }
        if (curMax > gMax) {
            gMax = curMax;
        }
        return gMax;
         */

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
            System.out.println(contiguousSubArray(arr, n));
        }
        in.close();
    }
}