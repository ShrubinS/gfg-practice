import java.util.*;


// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0/

public class ReverseArrayGroups {

    private static List<Integer> groupReverse(int[] arr, int n, int k) {

        List<Integer> retVal = new ArrayList<>();

        for (int i=k-1; i-n<k; i+=k) {
            int index = i;
            int iterTimes = k;
            if (n-1 < i) {
                index = n-1;
                int reduce = i-(n-1);
                iterTimes = k-reduce;
            }

            for (int j=index; iterTimes>0; iterTimes--, j--) {
                retVal.add(arr[j]);
            }
        }
        return retVal;
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
            int k = in.nextInt();
            List<Integer> ans = groupReverse(arr, n, k);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
