import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int longestSlideDown(int[][] pyramid) {
        List<Integer> newSlideDownRow = new ArrayList<>();
        List<Integer> tempSlideDown = new ArrayList<>();
        newSlideDownRow = Arrays.stream(pyramid[pyramid.length-1]).boxed().collect(Collectors.toList());
        for (int i = pyramid.length -2; i >= 0 ; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                int temMaxTotal = getBiggerSum(pyramid[i][j], newSlideDownRow.get(j), newSlideDownRow.get(j+1));
                tempSlideDown.add(temMaxTotal);
            }
            newSlideDownRow.removeAll(newSlideDownRow);
            newSlideDownRow.addAll(tempSlideDown);
            tempSlideDown.removeAll(tempSlideDown);



        }
        return newSlideDownRow.get(0);
        // Code Goes Here..
    }

    private static int getBiggerSum(int number, int index1, int index2){
        return number + Math.max(index1, index2);

    }

}