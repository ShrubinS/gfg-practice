import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Imp_MinimumPlatforms {

    /*

        https://practice.geeksforgeeks.org/problems/minimum-platforms/0

        TODO: Weird ambiguous test cases of GFG
        Tried on https://www.hackerrank.com/contests/kilobyte-uz-contest1/challenges/trains-and-platforms/problem
        Solution accepted
        O(n) time
        O(1) space

        See:
        https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
        for O(nlogn) runtime solution
     */

    private static int findMinPlatforms(int[] arrival, int[] departure, int n) {
        int[] dayArr = new int[2400];

        for (int i=0; i<n; i++) {
            for (int j=arrival[i]; j<departure[i]; j++) {
                dayArr[j]++;
            }
        }

        return Arrays.stream(dayArr).max().getAsInt();
    }

    public static void main (String[] args) {
        // code
        // modified for the hackerrank problem
        Scanner in = new Scanner(System.in);
        int t = 1;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arrival[arr_i] = in.nextInt();
                departure[arr_i] = in.nextInt();
            }
            System.out.println(findMinPlatforms(arrival, departure, n));
        }
        in.close();
    }
}
