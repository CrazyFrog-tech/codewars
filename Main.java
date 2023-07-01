import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;


public class Main {

    private static List<Integer> sortedList = new ArrayList<>();
    private static List<Integer> keysList = new ArrayList<>();


    // Driver code
    public static int[] snail(int[][] array) {
        boolean goingRight = false;
        boolean goingLeft = false;
        boolean goingDown =false;
        boolean goingUp = false;
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

                }
                if (columnNumber == horizontalArraySize || !keysList.contains(keyInt)) {

                    if(columnNumber == horizontalArraySize){
                        horizontalIndex = columnNumber;
                    }else {
                        horizontalIndex = 0;
                    }
                    columnNumber = horizontalArraySize;
                    if(keysList.contains(keyInt)){
                        horizontalIndex =0;
                    }

                }
                if (rowNumber == verticalArraySize && columnNumber != 0) {
                    horizontalIndex = columnNumber - 1;
                    rowNumber--;
                    break;

                }
                if (columnNumber == 0 && firstTime) {

                    int newRowNumber = rowNumber - 2;
                    int rownumberGood = rowNumber - 1;
                    String key1 = "" + rownumberGood + columnNumber;
                    int keyInt1 = Integer.parseInt(key1);
                    if(!keysList.contains(keyInt1)){
                        rowNumber = newRowNumber;
                        verticalIndex = rowNumber;
                        horizontalIndex = 0;
                        firstTime = false;
                        break;
                    }


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

