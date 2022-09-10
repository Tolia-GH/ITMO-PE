#include <iostream>

using namespace std;

class Matrix {
public:
    int c, r;
    double matrix [100][100];
    
    void inputSize() {
    	printf("Program: Please input the size of matrix:(in form\"r c\")\n");
    	scanf("%d %d",&r,&c);
	}
    void inputMatrix() {
    	inputSize();
	    printf("Program: You input r=%d, c=%d, now input the matrix:\n",r,c);
	
	    for (int i = 0; i < r; i++) {
	        for (int j = 0; j < c; j++) {
	            scanf("%lf", &matrix[i][j]);
	        }
	    }
	}
    void printMatrix() {
    	
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				printf("%8.2lf ", matrix[i][j]);
			}
			printf("\n");
		}
	}
    Matrix multiply(Matrix matrix) {
    	Matrix result;
		result.r = this->r;
		result.c = matrix.c;
		if (this->c == matrix.r) {
			for (int i = 0; i < result.r; i++) {
				for (int j = 0; j < result.c; j++) {
					result.matrix[i][j] = 0;
					for (int k = 0; k < matrix.r; k++) {
						result.matrix[i][j] += this->matrix[i][k] * matrix.matrix[k][j];
					}
				}
			}
		} else {
			printf("Error\n");
		}
		return result;
	}
	
};

void run() {
	Matrix matrix1;
    Matrix matrix2;

    matrix1.inputMatrix();
    matrix2.inputMatrix();
    
    Matrix matrix3;
	matrix3 = matrix1.multiply(matrix2);
	
    printf("Program: The product of matrix1 and matrix2 is:\n");
    matrix3.printMatrix();
    
    printf("\n");
    system("pause");
}

int main() {

    printf("Matrix Multiply version 1.0\n");
    printf("By: Zhou HongXiang P32131\n\n");
    
    while (true) {
    	run();
	}

    return 0;
}