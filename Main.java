public class Main {

    public static void mains(String[] args) {

    }


    // Function to multiply
    // two matrices A[][] and B[][]
    static int[][] multiplyMatrix(
        int row1, int col1, int[][] A,
        int row2, int col2, int[][] B)
    {
        int i, j, k;

        // Check if multiplication is Possible
        if ( col1 != row2) {

            System.out.println(
                "\nMultiplication Not Possible");
            return A;
        }

        int C[][] = new int[row1][col2];

        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }

        return C;
    }

    // Driver code
    public static void main(String[] args)
    {



        int A[][] = { { 1, 1, 1 },
            { 2, 2, 2 },
            { 3, 3, 3 },
            { 4, 4, 4 } };

        int B[][] = { { 1, 1, 1, 1 },
            { 2, 2, 2, 2 },
            { 3, 3, 3, 3 } };
        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;
        System.out.println(A[0].length + "A length");

        multiplyMatrix(row1, col1, A,
            row2, col2, B);
    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        return multiplyMatrix(a.length, a[0].length, a, b.length, b[0].length, b);
    }
}