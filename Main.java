import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        int interesting = 0;
        interesting += getNumberInteresting(number);
        interesting += getNumberNearingInteresting(number, awesomePhrases);
        return interesting;
    }

    private static int getNumberNearingInteresting(int number, int[] awesomePhrases) {
        for (int i = 0; i < awesomePhrases.length-1; i++) {
            if(number + 1 == awesomePhrases[i] || number + 2 == awesomePhrases[i]) {
                return 1;
            }
        }
        return 0;
    }

    private static int getNumberInteresting(int number) {
        if(number % 100 == 0){
            return 2;
        }


        return 0;
    }

}