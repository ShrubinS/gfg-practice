import java.util.*;

public class Imp_MaxSumIncSubseq {

    /*
        https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

        This is DP (lookup table)

        Recursive definition:
        Sum (smax) at at particular value(i) is the (max sum(smax') + i) of all values(i')
        that occurred before i and satisfy i'< i

        lookup table stores max sum (smax) for each value
     */

    private static int getMaxSumIncSubMap(int[] arr, int n) {
        Map<Integer, Integer> maxSumMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            int gMaxKey = -1;
            for (int key : maxSumMap.keySet()) {
                if (key < arr[i]) {
                    int tempMax = maxSumMap.get(key);
                    if (gMaxKey == -1 || tempMax > maxSumMap.get(gMaxKey)) {
                        gMaxKey = key;
                    }
                }
            }
            maxSumMap.put(arr[i], arr[i] + (gMaxKey == -1 ? 0 : maxSumMap.get(gMaxKey)));
        }
        return maxSumMap.values().stream().max(Integer::compareTo).get();
    }

    private static int getMaxSumIncSubArr(int[] arr, int n) {
        int[] maxValLookup = new int[n];
        System.arraycopy(arr, 0, maxValLookup, 0, n);

        for (int i = 1; i < n; i++ ) {
            for (int j = 0; j < i; j++ ) {
                if ( arr[i] > arr[j] && maxValLookup[i] < maxValLookup[j] + arr[i]) {
                    maxValLookup[i] = maxValLookup[j] + arr[i];
                }
            }

        }

        return Arrays.stream(maxValLookup).max().getAsInt();
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
            System.out.println(getMaxSumIncSubArr(arr, n));
        }
        in.close();
    }
}
