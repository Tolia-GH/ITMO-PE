#include <iostream>

using namespace std;

class Matrix {
public:
    int c, r;
    int matrix [100][100];
    void getSize();
    void getMatrix();
    static Matrix multiply(Matrix a, Matrix b);
};

void Matrix::getSize() {
    printf("Program: Please input the size of matrix(in form\"c r\")\n");
    scanf("%d %d",&c,&r);
}

void Matrix::getMatrix() {
    getSize();

    for (int i = 0; i < c; ++i) {
        for (int j = 0; i < r; ++j) {
            scanf("%d", &matrix[i][j]);
        }
    }
}

int main() {

    printf("Matrix Operation version 1.0\n");
    printf("Чжоу Хунсян P32131\n");

    Matrix matrix1;
    Matrix matrix2;

    matrix1.getMatrix();
    matrix2.getMatrix();

    return 0;
}
