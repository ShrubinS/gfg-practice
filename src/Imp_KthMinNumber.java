import java.util.*;
import java.util.stream.Collectors;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element/0/
// Important, PriorityQueue is basically heap data structure, So solution uses a heap

public class Imp_KthMinNumber {

    private static int kthMinNumber(int[] arr, int n, int k) {

        /*
            Natural Order Priority queue
            Solution in O(k*log(n) + n)
         */

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n, Integer::compareTo);
        priorityQueue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        int retVal = -1;
        for (int i=0; i<k; i++) {
            retVal = priorityQueue.poll();
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

            System.out.println(kthMinNumber(arr, n, k));
        }
        in.close();
    }
}
