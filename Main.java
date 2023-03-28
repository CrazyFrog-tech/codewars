public class Main {

    // Driver code
    public static void main(String[] args) {

    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        int interesting = 0;
        interesting = getNumberNearingInteresting(number, awesomePhrases) + numberInteresting(number);
        return interesting;
    }

    private static int getNumberNearingInteresting(int number, int[] awesomePhrases) {
        for (int i = 0; i < awesomePhrases.length - 1; i++) {
            if (number + 1 == awesomePhrases[i] || number + 2 == awesomePhrases[i]) {
                return 1;
            }
            if (number == awesomePhrases[i]) {
                return 2;
            }

            }
        return 0;
    }

    private static int numberInteresting(int number) {
        return checkSameDigits(number) + checkDecrementing(number) + checkIncrementing(number) + checkEndsWithPalindrome(number) + checkEndsWithZeros(number);
    }

    public static int checkSameDigits(int N) {
        int digit = N % 10;
        while (N != 0) {
            int current_digit = N % 10;

            N = N / 10;
            if (current_digit != digit) {
                return 0;
            }
        }
        return 2;
    }

    public static int checkIncrementing(int N) {
        int lastSeen = 10;
        while (N != 0) {
            int current_digit = N % 10;

            if (lastSeen != 10 && lastSeen -1  != current_digit) {
                return 0;
            }
            lastSeen = current_digit;
            N = N / 10;
        }
        return 2;
    }
    public static int checkDecrementing(int N) {
        int lastSeen = 10;
        while (N != 0) {
            int current_digit = N % 10;

            if (lastSeen != 10 && lastSeen+1  != current_digit) {
                return 0;
            }
            lastSeen = current_digit;
            N = N / 10;
        }
        return 2;
    }

    private static int checkEndsWithZeros(int number) {
        if (number % 100 == 0 && number > 99) {
            return 2;
        }
        return 0;
    }

    public static int checkEndsWithPalindrome(int number) {
        if(Integer.parseInt(Integer.toString(number).substring(0, 1)) != number % 10){
            return 0;
        }
        return 2;


    }

}