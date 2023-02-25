import java.util.Scanner;

public class Terminal {

    private static int n;
    private static double[][] inputMatrix = new double[21][22];

    public static void main(String[] args) {
        readData();
        Matrix matrix = new Matrix(n,inputMatrix);

        matrix.calDeterminant();
        matrix.getResultByGauss();

        System.out.println("The determinant of Matrix is:" + matrix.determinant);
        matrix.printMatrix(matrix.inputMatrix);
        matrix.printMatrix(matrix.firstMatrix);
        matrix.printMatrix(matrix.secondMatrix);
        matrix.printResult();
        matrix.printR();
    }

    static void readData() {
        System.out.println("System: Input number of unknown X.");
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        System.out.println("System: Now please input matrix (n*(n+1)).");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=n; j++) {
                inputMatrix[i][j] = sc.nextDouble();
            }
        }
    }
}
