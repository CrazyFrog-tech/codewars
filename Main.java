import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int[] smaller(int[] unsorted) {
        int[] counts = new int[unsorted.length];
        int[] indexes = new int[unsorted.length];

        // initialize indexes
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        mergeSort(unsorted, indexes, counts, 0, unsorted.length - 1);

        return counts;
    }

    private static void mergeSort(int[] arr, int[] indexes, int[] counts, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, indexes, counts, left, mid);
        mergeSort(arr, indexes, counts, mid + 1, right);
        merge(arr, indexes, counts, left, mid, right);
    }

    private static void merge(int[] arr, int[] indexes, int[] counts, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        int[] tempindexes = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                tempindexes[k] = indexes[i];
                counts[indexes[i]] += j - mid - 1;
                i++;
            } else {
                temp[k] = arr[j];
                tempindexes[k] = indexes[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            tempindexes[k] = indexes[i];
            counts[indexes[i]] += j - mid - 1;
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            tempindexes[k] = indexes[j];
            j++;
            k++;
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        System.arraycopy(tempindexes, 0, indexes, left, tempindexes.length);
    }

}