import java.util.Scanner;

public class Matrix {
    int n;
    public double[][] matrixTable = new double[21][22];
    public double [][] inputMatrix = new double[21][22];
    public double[][] firstMatrix = new double[21][22];
    public double[][] secondMatrix = new double[21][22];
    public double determinant;
    int sign = 1;

    double result[] = new double[21];
    double R[] = new double[21];

    public double[] getResults() {
        return result;
    }

    public Matrix() {}

    public Matrix(int n, double [][] matrixTable) {
        this.n = n;
        this.inputMatrix = matrixTable;
    }

    public void getResultByGauss() {

        matrixCopy(matrixTable, inputMatrix);

        for (int i = 0; i < n - 1; i++) {
            double max = Double.NEGATIVE_INFINITY;
            int maxIndex = i;
            for (int m = i; m < n; m++) {
                if (matrixTable[m][i]>max) {
                    max = matrixTable[m][i];
                    maxIndex = m;
                }
            }
            if (maxIndex != i) {
                swabLine(maxIndex, i);
            }
            for (int j = i + 1; j < n; j++) {
                double div = matrixTable[j][i]/matrixTable[i][i];
                for (int k = 0; k < n + 1; k++) {
                    matrixTable[j][k] = matrixTable[j][k] - div * matrixTable[i][k];
                    //matrixTable[j][k] *= matrixTable[i][i];
                }
            }
        }

        matrixCopy(firstMatrix, matrixTable);

        for (int i = n-1; i > 0; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                double div = matrixTable[j][i]/matrixTable[i][i];
                for (int k = 0; k < n + 1; k++) {
                    matrixTable[j][k] = matrixTable[j][k] - div * matrixTable[i][k];
                    //matrixTable[j][k] *= matrixTable[i][i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            double div = matrixTable[i][i];
            for (int j = 0; j < n + 1; j++) {
                matrixTable[i][j] = matrixTable[i][j]/div;
            }
        }

        matrixCopy(secondMatrix, matrixTable);

        for (int i = 0; i < n; i++) {
            result[i] = matrixTable[i][n];
        }


        for (int i = 0; i < n; i++) {
            double sum = 0L;
            for (int j = 0; j < n; j++) {
                sum += inputMatrix[i][j] * result[j];
            }
            R[i] = sum-inputMatrix[i][n];
        }
    }

    void swabCol(int r, int c) {
        for (int i = 0; i < n; i++)	{
            matrixTable[i][r] += matrixTable[i][c];
            matrixTable[i][c] = matrixTable[i][r] - matrixTable[i][c];
            matrixTable[i][r] -= matrixTable[i][c];
        }
        sign = -sign;
    }

    void swabLine(int r, int c) {
        for (int i = 0; i <= n; i++)	{
            matrixTable[r][i] += matrixTable[c][i];
            matrixTable[c][i] = matrixTable[r][i] - matrixTable[c][i];
            matrixTable[r][i] -= matrixTable[c][i];
        }
        sign = -sign;
    }

    void matrixCopy(double[][] matrix1, double[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = matrix2[i][j];
            }
        }
    }

    void printMatrix(double[][] matrix) {
        System.out.println("System: printing matrix.");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%3.2f ",matrix[i][j]);
            }
            System.out.println();
        }
    }

    void printResult() {
        System.out.println("The result is: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%3.2f ", result[i]);
        }
        System.out.println();
    }

    void printR() {
        System.out.println("The R is: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%3.20f ", R[i]);
        }
        System.out.println();
    }

    void calDeterminant() {
        sign = 1;
        matrixCopy(matrixTable,inputMatrix);
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrixTable[i][j] != 0) {
                    if (matrixTable[i][i] == 0) {
                        swabCol(i,j);
                    }
                    double div = matrixTable[i][j]/matrixTable[i][i];
                    for (int k = i; k < n; k++) {
                        matrixTable[k][j] = matrixTable[k][j] - div * matrixTable[k][i];
                    }
                }
            }
        }

        determinant = sign * matrixTable[0][0];
        for (int i = 1; i < n; i++) {
            determinant *= matrixTable[i][i];
        }
    }
}
