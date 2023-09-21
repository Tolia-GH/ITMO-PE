#include <string>
#include "iostream"

using namespace std;


int compare(const string &a, const string &b) {
    string temp1 = a + b;
    string temp2 = b + a;

    return temp1.compare(temp2);
}

void bubbleSort(string arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (compare(arr[j], arr[j + 1]) < 0) {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
}

int main() {
    string nums[100] = {};

    int count = 0;
    while(true) {
        cin >> nums[count];

        if (nums[count].empty()) {
            break;
        }

        count ++;
    }

    bubbleSort(nums, count);

    for (int i = 0; i < count; i++) {
        cout << nums[i];
    }

    return 0;
}