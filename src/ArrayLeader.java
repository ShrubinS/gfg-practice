import java.util.*;

// https://practice.geeksforgeeks.org/problems/leaders-in-an-array/0

public class ArrayLeader {

    private static List<Integer> numLeaders(int[] arr, int n) {
        List<Integer> leaders = new ArrayList<>();
        if (arr.length == 0) {
            return leaders;
        }

        int rMax = arr[arr.length-1];
        leaders.add(rMax);
        if (arr.length == 1) {
            return leaders;
        }

        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i] > rMax) {
                rMax = arr[i];
                leaders.add(rMax);
            }
        }
        Collections.reverse(leaders);
        return leaders;
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
            List<Integer> ans = numLeaders(arr, n);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.print("\n");
        }
        in.close();
    }
}
