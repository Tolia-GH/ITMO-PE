#include "string"
#include "iostream"
#include "cstring"

using namespace std;

int weight[26];
char stringS[100001];
char resultS[100001];
char topLetters[100001];
int resultIdx = 0;
int topIndex = 0;

int compare(char a, char b) {//if weight of b > a then res > 0
    if(weight[a - 'a']!=weight[b - 'a']){
        return weight[b - 'a'] - weight[a - 'a'];
    }
    return b - a;
}

void bubbleSort(char arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (compare(arr[j], arr[j + 1]) > 0) {
                char temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

void quickSort(char arr[], int l, int r) {
    if (l < r) {
        int i = l, j = r, c = arr[l];
        while (i < j) {
            while (i < j && compare(arr[j], c) >= 0) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && compare(arr[i], c) < 0) {
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

void printRes() {
    for (int i = 0; i < topIndex; i++) {
        cout << topLetters[i];
    }

    for (int i = 0; i < resultIdx; i++) {
        cout << resultS[i];
    }

    for (int i = topIndex - 1; i >= 0; i--) {
        cout << topLetters[i];
    }
}

int main() {
    cin >> stringS;

    int lengthS = strlen(stringS);

    for (int & i : weight) {
        cin >> i;
    }

    //bubbleSort(stringS, lengthS);
    quickSort(stringS, 0, lengthS);

    for(int i = 0; i< lengthS - 1; i++) {
        if (stringS[i + 1] == stringS[i]) {
            if (topIndex == 0 || topLetters[topIndex - 1] != stringS[i]) {
                topLetters[topIndex] = stringS[i];
                topIndex++;
                ++i;
            } else {
                resultS[resultIdx] = stringS[i];
                resultIdx++;
            }
        } else {
            resultS[resultIdx] = stringS[i];
            resultIdx++;
        }
    }

    if (lengthS != resultIdx + 2 * topIndex) {
        resultS[resultIdx++] = stringS[lengthS - 1];
    }

    printRes();

    return 0;
}