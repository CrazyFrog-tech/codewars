import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    private static List<Integer> sortedList = new ArrayList<>();
    private static List<Integer> keysList = new ArrayList<>();


    // Driver code
    public static int[] snail(int[][] array) {
        int horizontalIndex = 0;
        int verticalIndex = 0;

        int verticalArrayLength = array.length;
        int totalSize = array.length * array[0].length;
        boolean firstTime = false;
        for (int rowNumber = verticalIndex; rowNumber < verticalArrayLength; rowNumber++) {
            if (rowNumber > 0) {
                firstTime = true;
            }
            int horizontalArrayLength = array[rowNumber].length;
            for (int columnNumber = horizontalIndex; columnNumber < horizontalArrayLength; columnNumber++) {
                int number = array[rowNumber][columnNumber];
                int horizontalArraySize = horizontalArrayLength - 1;
                int verticalArraySize = verticalArrayLength - 1;
                String key = "" + rowNumber + columnNumber;
                int keyInt = Integer.parseInt(key);

                if (
                        !keysList.contains(keyInt)) {
                    sortedList.add(number);
                    keysList.add(keyInt);
                    if (columnNumber == horizontalArraySize) {
                        horizontalIndex = columnNumber;
                    }
                }
                if (rowNumber == verticalArraySize && columnNumber != 0) {
                    horizontalIndex = columnNumber - 1;
                    rowNumber--;

                }
                if (columnNumber == 0 && firstTime) {
                    rowNumber = rowNumber - 1;

                    verticalIndex = rowNumber;
                    horizontalIndex = 0;
                    columnNumber = -1;
                    firstTime = false;
                }
                if (sortedList.size() == totalSize) {
                    break;
                }
            }
            if (sortedList.size() == totalSize) {
                break;
            }

        }
        // enjoy
        return sortedList.stream().mapToInt(i -> i).toArray();
    }

}
}

