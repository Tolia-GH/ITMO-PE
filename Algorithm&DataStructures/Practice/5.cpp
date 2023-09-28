#include <iostream>
#include <vector>

using namespace std;

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

int main() {
    int n;
    int k;

    read(n);
    read(k);

    vector<int> coordinates;

    for (int i = 0; i < n; i ++) {
        int coordinate;
        read(coordinate);
        coordinates.push_back(coordinate);
    }

    int left = 0;
    int right = coordinates[n - 1] - coordinates[0] + 1;
    int middle = (left + right) / 2;
    int last = coordinates[0];

    while (left < right) {
        int count = 1;

        for (int i = 1; i < n; ++i) {
            if (coordinates[i] - last > middle) {
                last = coordinates[i];
                count++;
            }
        }

        if (count >= k) {
            left = middle + 1;
        } else {
            right = middle;
        }

        middle = (left + right) / 2;
        last = coordinates[0];
    }

    write(left);

    return 0;
}
