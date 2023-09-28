#include <iostream>
#include <deque>
#include <cstdio>
#include <cstdlib>
#include <string>
#include <cstring>

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

int main() {
    int n;
    read(n);
    deque<int> left, right;

    char request;
    int id;
    loop: for (int i = 0; i < n; ++i) {

        request = getchar();

        switch (request) {
            case '+':
                read(id);
                right.push_back(id);
                break;
            case '*':
                read(id);
                right.push_front(id);
                break;
            case '-':
                cout << left.front() << endl;
                left.pop_front();
                break;
            case '\n':
                --i;
        }

        if (left.size() < right.size()) {
            left.push_back(right.front());
            right.pop_front();
        }
    }

    return 0;
}