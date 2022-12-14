import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

    }

    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;
//        printValues(a);
//        printValues(b);

        return multiplyMatrix(row1, col1, a,
                row2, col2, b);
    }

    private static void printValues(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("Values at arr["+i+"]["+j+"] is "+ a[i][j]);
            }

        }
    }

    static int[][] multiplyMatrix(
            int row1, int col1, int A[][],
            int row2, int col2, int B[][])
    {
        int i, j, k;

        // Print the matrices A and B
        System.out.println("\nMatrix A:");
        System.out.println("\nMatrix B:");

        // Check if multiplication is Possible
        if (row2 != col1) {

            System.out.println(
                    "\nMultiplication Not Possible");
            return null;
        }

        // Matrix to store the result
        // The product matrix will
        // be of size row1 x col2
        int C[][] = new int[row1][col2];

        // Multiply the two matrices
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }

        // Print the result
        System.out.println("\nResultant Matrix:");
        return C;
    }
    public static int[][] multiply(int[][] A, int[][] B, int rowA, int colA,
                                   int rowB, int colB, int size) {
        int[][] C = new int[size][size];
        if (size == 1) {
            C[0][0] = A[rowA][colA] * B[rowB][colB];
        } else {
            int newSize = size / 2;
            // C11 = A11 * B11 + A12 * B21
            add(C, multiply(A, B, rowA, colA, rowB, colB, newSize),//A11*B11
                    multiply(A, B, rowA, colA + newSize, rowB + newSize, colB, newSize), //A12*B21
                    0, 0);//C11

            // C12 = A11 * B12 + A12 * B22
            add(C, multiply(A, B, rowA, colA, rowB, colB + newSize, newSize),//A11*B12
                    multiply(A, B, rowA, colA + newSize, rowB + newSize, colB + newSize, newSize),//A12*B22
                    0, newSize);//C12

            // C21 = A21 * B11 + A22 * B21
            add(C, multiply(A, B, rowA + newSize, colA, rowB, colB, newSize),//A21*B11
                    multiply(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB, newSize),//A22*B21
                    newSize, 0);//C21

            // C22 = A21 * B12 + A22 * B22
            add(C, multiply(A, B, rowA + newSize, colA, rowB, colB + newSize, newSize),//A21*B12
                    multiply(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB + newSize, newSize), //A22*B22
                    newSize, newSize);//C22
        }

        return C;
    }

    private static void add(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i + rowC][j + colC] = A[i][j] + B[i][j];
            }
        }

    }


}