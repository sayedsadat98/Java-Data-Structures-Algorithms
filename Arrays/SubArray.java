package Arrays;

//Print all the subarrays (Brute force)

public class SubArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 66, 88, 99};

        int[] arr = {-1, 4, 7, 2};
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
