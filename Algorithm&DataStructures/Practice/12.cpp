#include "iostream"
#include "deque"
#include "vector"

using namespace std;

int n, k;
deque<int> window;

inline void read(int &num) {//fast read
    num = 0;
    short flag = 1;
    char ch = getchar();
    while (ch < '0' || ch > '9') {
        if (ch == '-') flag = -1;
        ch = getchar();
    }
    while (ch >= '0' && ch <= '9') {
        num = (num << 3) + (num << 1) + (ch ^ 48);
        ch = getchar();
    }
    num *= flag;
}

inline void write (int num) {//fast write
    if (num == 0) return;
    write(num / 10);
    putchar(num % 10 + '0');
}

void getFirstRes(vector<int> nums) {
        for (int i = 0; i < k; ++i) {
        while (!window.empty() && nums[i] < nums[window.back()]) {
            window.pop_back();
        }

        window.push_back(i);
    }

    cout << nums[window.front()] << " ";
}

void getSecondRes(vector<int> nums) {
    for (int i = k; i < n; ++i) {
        if (!window.empty() && window.front() == i - k) window.pop_front();
        
        while (!window.empty() && nums[i] < nums[window.back()]) {
            window.pop_back();
        }
        window.push_back(i);
        cout << nums[window.front()] << " ";
    }
}

void getRes() {
    vector<int> nums(n);//get nums[]
    for (int i = 0; i < n; ++i) {
        read(nums[i]);
    }

    getFirstRes(nums);
    getSecondRes(nums);

}

int main() {
    read(n);
    read(k);

    getRes();

    return 0;
}
