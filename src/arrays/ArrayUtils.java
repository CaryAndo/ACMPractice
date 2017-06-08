package arrays;

/**
 * Created by cary on 5/23/17.
 */
public final class ArrayUtils {

    /**
     * Print three indices that add to 0 in a given array
     * My approach uses O(n^2) time and O(n^2) space
     * (optimal approach uses binary search and log(n) space or time I can't remember)
     *
     * @param arr The array in which to find the sums
     */
    public static void printThreeSums(int[] arr) {

    }

    /**
     * Given a matrix sorted by rows and columns
     * (running down a row is increasing, running down a column is also increasing)
     * Write the code to get the nth highest element
     *
     * @param arr The matrix to retrieve the element from
     * @param n The number in sequence to retrieve
     * @return The nth largest number in the matrix
     */
    public static int getNthLargest(int[][] arr, int n) {
        int[] pointers = new int[arr[0].length]; // Create a pointer for every column

        int minColumn = 0;

        // n times
        for (int i = 0; i < n; i++) {
            // Run through our list of pointers and find the smallest one
            // (for every column)
            for (int j = 0; j < pointers.length; j++) {
                if (pointers[j] > arr.length) {
                    continue;
                }

                // Check if that column contains our
                if (arr[pointers[j]][j] > arr[pointers[minColumn]][minColumn]) {
                    minColumn = j;
                    pointers[j]++;
                }
            }

        }

        return arr[pointers[minColumn]][minColumn];
    }

    /**
     * Return whether a matrix is a Toeplitz matrix
     * A Toeplitz matrix is a matrix where all diagonals
     * are the same number
     *
     * Example:
     * 7 3 5 1
     * 2 7 3 5
     * 1 2 7 3
     * 4 1 2 7
     *
     * @param arr The matrix to check
     * @return Whether or not the matrix is a valid Toeplitz matrix
     */
    public static boolean isToeplitz(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (!checkDiagnal(arr, 0, i)) {
                return false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!checkDiagnal(arr, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDiagnal(int[][] arr, int row, int col) {
        if (arr == null || row > arr.length || col > arr[0].length) {
            return false;
        }

        int lastValue = arr[row][col];
        int loopTo = Math.min(arr.length - row, arr[0].length - col);

        for (int i = 0; i < loopTo; i++) {
            if (arr[row + i][col + i] != lastValue) {
                System.out.println("Returning false because: " + arr[row + i][col + i] + " is != " + lastValue);
                return false;
            }
        }

        return true;
    }


    /**
     * 7 3 5 1
     * 2 7 3 5
     * 1 2 7 3
     * 4 1 2 7
     */
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
