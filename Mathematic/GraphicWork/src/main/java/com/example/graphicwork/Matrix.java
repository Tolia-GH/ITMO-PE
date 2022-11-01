package com.example.graphicwork;

public class Matrix {
    int n=3;
    public double[][] matrixTable = new double[3][4];
    public double [][] inputMatrix = new double[3][4];
    public double[][] firstMatrix = new double[3][4];
    public double[][] secondMatrix = new double[3][4];

    double resultX;
    double resultY;
    double resultZ;

    public double getResultX() {
        return resultX;
    }

    public double getResultY() {
        return resultY;
    }

    public double getResultZ() {
        return resultZ;
    }

    public Matrix(double a11, double a12, double a13, double b1,
                  double a21, double a22, double a23, double b2,
                  double a31, double a32, double a33, double b3) {
        matrixTable[0][0] = a11; matrixTable[0][1] = a12; matrixTable[0][2] = a13; matrixTable[0][3] = b1;
        matrixTable[1][0] = a21; matrixTable[1][1] = a22; matrixTable[1][2] = a23; matrixTable[1][3] = b2;
        matrixTable[2][0] = a31; matrixTable[2][1] = a32; matrixTable[2][2] = a33; matrixTable[2][3] = b3;
    }

    public void getResultByGauss() {

        matrixCopy(inputMatrix, matrixTable);

        for (int i = 0; i < n - 1; i++) {
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

        resultX = matrixTable[0][3];
        resultY = matrixTable[1][3];
        resultZ = matrixTable[2][3];
    }

    void swabCol(int r, int c) {
        for (int i = 0; i < 4; i++)	{
            matrixTable[i][r] += matrixTable[i][c];
            matrixTable[i][c] = matrixTable[i][r] - matrixTable[i][c];
            matrixTable[i][r] -= matrixTable[i][c];
        }
    }

    void matrixCopy(double[][] matrix1, double[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = matrix2[i][j];
            }
        }
    }
}
