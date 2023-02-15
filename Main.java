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
        if(number % 100 == 0 && number > 99){
            return 2;
        }
        // for incremental decremental convert to string and check each digit if it's smaller than the next one or greater.


        return 0;
    }

}