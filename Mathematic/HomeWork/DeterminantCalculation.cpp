#include <iostream>

using namespace std;

class Determinant {
public:
	int n;
	double det[100][100];
	double value;
	int sign = 1;
	
	void inputSize() {
    	printf("Program: Please input the size of determinant:\n");
    	scanf("%d",&n);
	}
    void inputDet() {
    	inputSize();
	    printf("Program: You input n=%d, now input the determinant:\n",n);
	
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            scanf("%lf", &det[i][j]);
	        }
	    }
	}
    void printDet() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				printf("%6.2lf ", det[i][j]);
			}
			printf("\n");
		}
	}
	void swabCol(int r, int c) {
		for (int i = 0; i < n; i++)	{
			det[i][r] += det[i][c];
			det[i][c] = det[i][r] - det[i][c];
			det[i][r] -= det[i][c];
		}
		sign = -sign;
	}
	void calValue() {
		for (int i = 0; i < n-1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (det[i][j] != 0) {
					if (det[i][i] == 0) {
						swabCol(i,j);
					}
					double div = det[i][j]/det[i][i];
					for (int k = i; k < n; k++) {
						det[k][j] = det[k][j] - div * det[k][i];
					}
				}
			}
		}
		
		value = sign * det[0][0];
		for (int i = 1; i < n; i++) {
			value *= det[i][i];
		}
	}
};

void run() {
	Determinant det;

    det.inputDet();
    printf("Program: The original determinant:\n");
    det.printDet();
    det.calValue();
    printf("Program: The triangle determinant:\n");
    det.printDet();
	
    printf("Program: The value of determinant is: %.2lf\n", det.value);
    
    printf("\n");
    system("pause");
}

int main() {
	printf("Determinant Calculator version 1.0\n");
    printf("By: Zhou HongXiang P32131\n\n");
	
	while (true) {
		run();
	}
	return 0;
}