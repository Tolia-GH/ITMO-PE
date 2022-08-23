//Variant: 21324
import java.util.Random;

public class Main {
    public static void main(String[] str) {
        ThreeArray threeArray = new ThreeArray(9, 17, -14.0d, 6.0d);
        threeArray.fillArray_a();
        threeArray.fillArray_x();
        threeArray.calculate_ans();
        threeArray.print_ans();
    }
}

class ThreeArray {
    int[] a;
    double[] x;
    double[][] ans;
    double minRand;
    double maxRand;

    public ThreeArray(int limit_a, int limit_x, double minRand, double maxRand) {
        a = new int[limit_a];
        x = new double[limit_x];
        ans = new double[limit_a][limit_x];
        this.minRand = minRand;
        this.maxRand = maxRand;
    }

    void fillArray_a() {
        for(int i = 0; i < a.length; i++) {
            a[i] =4 + i * 2 + 1;
        }
    }

    void fillArray_x() {
        for(int i = 0; i < x.length; i++) {
            x[i] = minRand + new Random().nextDouble() * (maxRand - minRand);
        }
    }

    void calculate_ans() {
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[i].length; j++) {
                if(a[i] == 13) {
                    ans[i][j] = Math.tan(Math.cos(Math.sin(x[j])));
                }
                else if(a[i] == 5 || a[i] == 9 || a[i] == 15 || a[i] == 17) {
                    ans[i][j] = Math.pow(Math.sin(Math.pow(Math.E, x[j]) / 2d), Math.pow((2d / 3) / Math.pow(Math.E, x[j]), 2));
                }
                else {
                    ans[i][j] = Math.pow(Math.asin(Math.sin(Math.cos(Math.cos(x[j])))) - 1, 3);
                }

            }
        }
    }

    void print_ans() {
        for (double[] line : ans) {
            for (double answer : line) {
                System.out.printf("%6.2f ", answer);
            }
            System.out.println();
        }
    }
}
