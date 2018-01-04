import java.util.*;

// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0/

/*
    Problem is easy, writing the code can be optimized in number of conditionals
    -- this solution can be optimized more
 */

public class Imp_StockBuySell {

    private static String maxProfit(int[] arr, int n) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("");

        int lowIndex = -1;
        boolean incr = false;
        for (int i=1; i<n; i++) {
            if (arr[i] >= arr[i-1]) {
                if (arr[i] > arr[i-1] && !incr) {
                    lowIndex = i-1;
                    incr = true;
                }

                if (i == n-1) {
                    stringBuffer.append("(").append(lowIndex).append(" ").append(i).append(") ");
                }
            } else {
                if (lowIndex != -1) {
                    stringBuffer.append("(").append(lowIndex).append(" ").append(i - 1).append(") ");
                }

                incr = false;
                lowIndex = -1;
            }
        }

        String retVal = stringBuffer.toString();

        return retVal.equals("") ? "No Profit" : retVal;
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
            System.out.println(maxProfit(arr, n));
        }
        in.close();
    }
}