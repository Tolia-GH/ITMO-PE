#include "iostream"
#include "deque"
#include "vector"

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> numbers(n);

    deque<int> window;
    for (int i = 0; i < k; ++i) {
        while (!window.empty() && numbers[i] < numbers[window.back()]) {
            window.pop_back();
        }
        window.push_back(i);
    }

    cout << numbers[window.front()] << " ";

    for (int i = k; i < n; ++i) {
        if (!window.empty() && window.front() == i - k) {
            window.pop_front();
        }
        while (!window.empty() && numbers[i] < numbers[window.back()]) {
            window.pop_back();
        }
        window.push_back(i);
        cout << numbers[window.front()] << " ";
    }

    return 0;
}