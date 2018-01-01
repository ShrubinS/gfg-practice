import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

public class MissingNumberInArray {

    /*
        time: O(n)
        space: O(1)
     */
    private static int missingNumberMath(int[] arr, int n) {
        int total = n*(n+1)/2;
        for (int number : arr) {
            total -= number;
        }
        return total;
    }

    /*
        time : O(n)
        space : O(n)
     */
    private static int missingNumber(int[] arr, int n) {
        int[] hash = new int[n+1];
        for (int number : arr) {
            hash[number] = 1;
        }
        for (int i=1; i<n+1; i++) {
            if(hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n-1];
            for(int arr_i = 0; arr_i < n-1; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(missingNumberMath(arr, n));
        }
        in.close();
    }

}
