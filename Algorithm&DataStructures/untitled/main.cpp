#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

int main() {
    int n;
    int k;
    int coordinates[1000000000];

    cin >> n >> k;

    for (int i = 0; i < n; i ++) {
        cin >> coordinates[i];
    }

    int left = 0;
    int right = coordinates[n - 1] - coordinates[0] + 1;
    int middle = (left + right) / 2;
    int last = coordinates[0];

    while (left < right) {
        int c = 1;

        for (int i = 1; i < n; ++i) {
            if (coordinates[i] - last > middle) {
                last = coordinates[i];
                c++;
            }
        }

        if (c >= k) {
            left = middle + 1;
        } else {
            right = middle;
        }
    }

    cout << left;
}
