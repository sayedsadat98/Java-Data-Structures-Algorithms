package Arrays;

//Print all the subarrays (Optimization I - Prefix Sum ==> O(n^2))


public class SubArrayPrefixSum {
    public static void main(String[] args) {
        int[] arr1 = {-1, 4, 7, 2};
        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};
        int n = arr.length;
        int prevSum = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        int currentSum = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                currentSum = (i > 0) ? arr[j] - arr[i - 1] : arr[j];

            }

            if (currentSum > prevSum) {
                prevSum = currentSum;
            }
        }
        System.out.println(prevSum);

    }


}
