import java.util.*;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0/

public class PythagoreanTriplet {

    /*
        O(n^2) time complexity
        can do j=0 to n because although this can satisfy a^2 + a^2 = 2a^2 => root(2)*a cannot be an integer
     */

    private static boolean triplet(int[] arr, int n) {

        List<Integer> localArr = Arrays.stream(arr).boxed().map(a -> a*a).collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(localArr);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (set.contains(localArr.get(i) + localArr.get(j))) {
                    return true;
                }
            }
        }

        return false;
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

            System.out.println(triplet(arr, n)? "Yes" : "No");
        }
        in.close();
    }

}
