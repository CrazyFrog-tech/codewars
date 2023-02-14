import java.util.ArrayList;
import java.util.List;

public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int longestSlideDown(int[][] pyramid) {
        int sum = pyramid[0][0];
        int index = 0;

        for (int i = 1; i < pyramid.length; i++) {
            if(pyramid[i][index + 1] > pyramid[i][index] ){
                index = index + 1;

            }
             sum += pyramid[i][index];

        }


        return sum;
        // Code Goes Here..
    }

}