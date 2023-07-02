import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    private static List<Integer> sortedList = new ArrayList<>();
    private static List<Integer> keysList = new ArrayList<>();


    // Driver code
    public static int[] snail(int[][] array) {
        int rows = array.length;
        if (rows == 0) {
            return new int[0];
        }

        int columns = array[0].length;
        int totalSize = rows * columns;
        int[] sortedArray = new int[totalSize];

        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        int index = 0;

        while (index < totalSize) {
            // Traverse right
            for (int i = left; i <= right && index < totalSize; i++) {
                sortedArray[index++] = array[top][i];
            }
            top++;

            // Traverse down
            for (int i = top; i <= bottom && index < totalSize; i++) {
                sortedArray[index++] = array[i][right];
            }
            right--;

            // Traverse left
            for (int i = right; i >= left && index < totalSize; i--) {
                sortedArray[index++] = array[bottom][i];
            }
            bottom--;

            // Traverse up
            for (int i = bottom; i >= top && index < totalSize; i--) {
                sortedArray[index++] = array[i][left];
            }
            left++;
        }

        return sortedArray;
    }


}

//                if (columnNumber == horizontalArraySize || !keysList.contains(keyInt)) {
//
//                    if(columnNumber == horizontalArraySize){
//                        horizontalIndex = columnNumber;
//                    }else {
//                        horizontalIndex = 0;
//                    }
//                    columnNumber = horizontalArraySize;
//                    if(keysList.contains(keyInt)){
//                        horizontalIndex =0;
//                    }
//
//                }
//                if (rowNumber == verticalArraySize && columnNumber != 0) {
//                    horizontalIndex = columnNumber - 1;
//                    rowNumber--;
//                    break;
//
//                }
//                if (columnNumber == 0 && firstTime) {
//
//                    int newRowNumber = rowNumber - 2;
//                    int rownumberGood = rowNumber - 1;
//                    String key1 = "" + rownumberGood + columnNumber;
//                    int keyInt1 = Integer.parseInt(key1);
//                    if(!keysList.contains(keyInt1)){
//                        rowNumber = newRowNumber;
//                        verticalIndex = rowNumber;
//                        horizontalIndex = 0;
//                        firstTime = false;
//                        break;
//                    }
//
//
//                }