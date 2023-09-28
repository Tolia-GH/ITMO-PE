#include <cstdio>
#include <cstdlib>
#include <algorithm>

using namespace std;

int cmp(const void* a, const void* b) {
    return *(int*)b - *(int*)a;
}

inline void read(int &num) {
    num = 0;
    short flag = 1;
    char ch = getchar();
    while(ch < '0' || ch > '9') {

        if(ch == '-')flag = -1;
        ch = getchar();
    }
    while(ch >= '0' && ch <= '9') {
        num = (num << 3) + (num << 1) + (ch ^ 48);
        ch = getchar();
    }
    num *= flag;
}

inline void write(int num) {
    if (num == 0) return;
    write(num / 10);
    putchar(num % 10 + '0');
}

void quickSort(int arr[], int l, int r) {  //from big to small
    if (l < r) {
        int i = l, j = r, c = arr[l];
        while (i < j) {
            while (i < j && c >= arr[j]) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && c < arr[i]) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = c;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
}

int main() {
    int n;  // number of things
    int k;  // every k-th thing free
    int prices[100001];  //price of all things
    int sum = 0;

    read(n);
    read(k);

    for (int i = 0; i < n; i++) {
        read(prices[i]);
    }

    qsort(prices, n, sizeof(int), cmp);

    for (int i = 0; i < n; i++) {
        if((i + 1) % k != 0) {
            sum += prices[i];
        }
    }

    printf("%d", sum);

    return 0;
}
