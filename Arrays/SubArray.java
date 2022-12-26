package Arrays;

//Print all the subarrays (Brute force - O(n^3))

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 3, 4, -1, 5, -12, 6, 1, 3};

        int[] arr1 = {-1, 4, 7, 2};
        int n = arr.length;
        int prevSum = Integer.MIN_VALUE;
        int currentSum;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];

                }
                prevSum = (currentSum > prevSum) ? currentSum : prevSum;

            }
        }
        System.out.println(prevSum);

    }
}
