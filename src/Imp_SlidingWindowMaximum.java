import java.util.*;

/*
    https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0
    Important solution using dequeue
    Time complexity : O(n)
    Space complexity: O(k)
*/


public class Imp_SlidingWindowMaximum {

    private static int[] slidingWindowMax(int[] arr, int n, int k) {

        if (arr == null || n < k) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] retVal = new int[n-k+1];

        for (int i=0; i<n; i++) {

            // remove expired elements from head
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1) {
                deque.poll();
            }

            // check next element condition on tail
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i >= k-1) {
                // i-k+1 >= 0 onwards
                retVal[i-k+1] = arr[deque.peekFirst()];
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
            int k = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] ans = slidingWindowMax(arr, n, k);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
