import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    private static List<Integer> sortedList = new ArrayList<>();

    // Driver code
    public static int[] snail(int[][] array) {
        int horizontalIndex = 0;
        int verticalIndex = 0;

        int verticalArrayLength = array.length;
        int totalSize = array.length * array[0].length;
        boolean firstTime = false;
        for (int rowNumber = verticalIndex; rowNumber < verticalArrayLength; rowNumber++) {
            if(rowNumber > 0){
                firstTime = true;
            }
            int horizontalArrayLength = array[rowNumber].length;
            for (int columnNumber = horizontalIndex; columnNumber < horizontalArrayLength; columnNumber++) {
                int number = array[rowNumber][columnNumber];
                int horizontalArraySize = horizontalArrayLength - 1;
                int verticalArraySize = verticalArrayLength - 1;

                if (!sortedList.contains(number)) {
                    sortedList.add(number);
                    if (columnNumber == horizontalArraySize) {
                        horizontalIndex = columnNumber;
                    }
                }
                if (rowNumber == verticalArraySize && columnNumber !=0) {
                    horizontalIndex= columnNumber-1;
                    rowNumber--;

                }
                if (columnNumber == 0 && firstTime) {
                    rowNumber= rowNumber-1;

                    verticalIndex = rowNumber;
                    horizontalIndex = 0;
                    columnNumber = -1;
                    firstTime = false;
                }
                if(sortedList.size() == totalSize){
                    break;
                }
            }
            if(sortedList.size() == totalSize){
                break;
            }

        }
        // enjoy
        return sortedList.stream().mapToInt(i -> i).toArray();
    }

    public static void goRight(int[] array) {
        for (int i = 0; i < array.length; i++) {
            sortedList.add(i);

        }
    }
}

