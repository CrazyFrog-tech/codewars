import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int[] smaller(int[] unsorted) {
        int[] counts = new int[unsorted.length];
        int[] indices = new int[unsorted.length];

        // initialize indices
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        mergeSort(unsorted, indices, counts, 0, unsorted.length - 1);

        return counts;
    }

    private static void mergeSort(int[] arr, int[] indices, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, indices, counts, left, mid);
        mergeSort(arr, indices, counts, mid + 1, right);
        merge(arr, indices, counts, left, mid, right);
    }

    private static void merge(int[] arr, int[] indices, int[] counts, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        int[] tempIndices = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                tempIndices[k] = indices[i];
                counts[indices[i]] += j - mid - 1;
                i++;
            } else {
                temp[k] = arr[j];
                tempIndices[k] = indices[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            tempIndices[k] = indices[i];
            counts[indices[i]] += j - mid - 1;
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            tempIndices[k] = indices[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        System.arraycopy(tempIndices, 0, indices, left, tempIndices.length);
    }

}