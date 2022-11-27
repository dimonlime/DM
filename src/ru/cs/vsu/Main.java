package ru.cs.vsu;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(n);
        int[][] A = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] str = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(str[j]);
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(determinantOfMatrix(A, n));
        File file1 = new File("output.txt");
        PrintWriter pw = new PrintWriter(file1);
        pw.println(determinantOfMatrix(A, n));
        pw.close();
    }

    private static void getCofactor(int[][] mat, int[][] temp, int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static int determinantOfMatrix(int mat[][], int n)
    {
        int D = 0;

        if (n == 1)
            return mat[0][0];

        int temp[][] = new int[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);
            sign = -sign;
        }

        return D;
    }

}
