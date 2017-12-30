import java.util.*;

public class Sort012Array {

    private static List<Integer> sort012Array(int[] arr, int n) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int element : arr) {
            linkedList.add(element);
        }

        int index=0;
        for (int iter=1; iter<n+1; iter++) {
            if (linkedList.get(index) == 2) {
                int val = linkedList.remove(index);
                linkedList.addLast(val);
                continue;
            }

            if (linkedList.get(index) == 0) {
                int val = linkedList.remove(index);
                linkedList.addFirst(val);
            }

            index++;
        }


        return linkedList;
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
            List<Integer> ans = sort012Array(arr, n);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println("\n");
        }
        in.close();
    }
}
