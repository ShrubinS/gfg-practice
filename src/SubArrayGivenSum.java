import java.util.*;

class Index {
    int start = -1;
    int end = -1;

    @Override
    public String toString() {
        if (end >= start) {
            return start + " " + end;
        }
        return "-1";
    }
}

public class SubArrayGivenSum {

    private static Index subArrayIndices(int[] arr, int n, int sum) {
        Index index = new Index();
        int floatingSum = arr[0];
        index.start = 1;
        for (int i=1; i<n; i++) {
            index.end = i+1;
            floatingSum += arr[i];
            while (floatingSum > sum) {
                floatingSum -= arr[index.start-1];
                index.start++;
            }
            if (floatingSum == sum) {
                return index;
            }
            if (index.start > index.end) {
                return index;
            }
        }
        // nope
        index.start = n+1;
        return index;
    }

    public static void main (String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int sum = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(subArrayIndices(arr, n, sum));
        }
        in.close();
    }
}
