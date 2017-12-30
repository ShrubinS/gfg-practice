import java.util.*;

public class Equilibrium {


    private static int equilibriumPoint(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int lhs = 0;
        int equilibrium = -1;

        for (int i=0; i<n; i++) {
            if (lhs == sum - lhs - arr[i]) {
                equilibrium = i+1;
                break;
            } else if (lhs < sum - lhs - arr[i]) {
                lhs += arr[i];
            } else {
                break;
            }
        }
        return equilibrium;
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
            System.out.println(equilibriumPoint(arr, n));
        }
        in.close();
    }
}
