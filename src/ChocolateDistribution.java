import java.util.*;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0

public class ChocolateDistribution {

    /*
        O(nlog(n)): time complexity solution by sorting
        O(n): space

        can also use min-heap (priority queue), same complexity
     */
    private static int distribution(int[] arr, int n, int m) {
        List<Integer> sortedList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        for (int i=0, j=m-1; j<n; i++, j++) {
            int localMin = sortedList.get(j) - sortedList.get(i);
            if (localMin < min) {
                min = localMin;
            }
        }

        return min;
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
            int m = in.nextInt();
            System.out.println(distribution(arr, n, m));
        }
        in.close();
    }
}