import java.util.*;

// https://practice.geeksforgeeks.org/problems/trapping-rain-water/0/

public class Imp_TrappingRainWater {

    /*
        1. take first and last non-zero -- find min of those -- calculate volume
        2. move first ahead, and last behind, until next is bigger than min
        3. repeat 1 until first >= last

        Comments:

        unable to get linear time solution -- genArrSum must be recalculated each time


        private static int trappedWater(int[] arr, int n) {

        int[] genArr = arr.clone();

        if (genArr == null || n <= 1) {
            return 0;
        }
        int first = 0;
        int last = n-1;

        int localMin = -1;
        int offset = 0;

        int retVolume = 0;

        int genArrSum = Arrays.stream(genArr).sum();
        int genArrCount = (int)Arrays.stream(genArr).filter(x -> x>0).count();

        int valAtFirst, valAtLast;
        while (first < last) {

            while ((first < last) && (genArr[first] - offset) <= 0) {
                first++;
            }
            while ((first < last) && (genArr[last] - offset) <= 0) {
                last--;
            }

            if (first >= last) {
                break;
            }

            valAtFirst = genArr[first];
            valAtLast = genArr[last];
            localMin = Math.min(valAtFirst, valAtLast);

            genArrSum = genArrSum - (offset * genArrCount);

            genArrSum -= (valAtFirst + valAtLast);

            int volume = localMin*(last-first-1) // total volume between first and last
                    - (genArrSum); //
            int localVolume = Math.max(0, volume);
            retVolume += localVolume;

            genArrCount -= 2;
            offset += localMin;
            first++;
            last--;

        }

        return retVolume;

    }

     */



    /*
        Solution by looking at how much water can be accumulated in each position of the array

        min(max-height-right[i], max-height-left[i]) - arr[i] is the water accumulated at i

        max-height-right[i] and max-height-left[i] can be precalculated in O(n) time for n-length array.
     */
    private static int trappedWaterDP(int[] arr, int n) {

        if (arr == null || n < 3) {
            return 0;
        }

        int[] maxHeightRight = new int[n];
        int[] maxHeightLeft = new int[n];

        maxHeightLeft[0] = -1;
        maxHeightRight[n-1] = -1;

        int maxLeft = arr[0], maxRight = arr[n-1];
        for(int i=1; i<n; i++) {
            maxHeightLeft[i] = maxLeft;
            maxLeft = Math.max(maxLeft, arr[i]);
        }

        for(int i=n-2; i>=0; i--) {
            maxHeightRight[i] = maxRight;
            maxRight = Math.max(maxRight, arr[i]);
        }

        int retValVolume = 0;
        int vol;
        for (int i=1; i<n-1; i++) {
            vol = Math.min(maxHeightLeft[i], maxHeightRight[i]) - arr[i];
            retValVolume += Math.max(0, vol);
        }

        return retValVolume;
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
            System.out.println(trappedWaterDP(arr, n));
        }
        in.close();
    }
}
