#include <iostream>

int main() {
    int n;//amount of flowers
    scanf("%d", &n);

    int flowers[n];//array of flowers

    for (int i = 0; i < n; ++i) {//input flowers
        scanf("%d", &flowers[i]);
    }

    if (n < 3) {
        printf("%d %d", 1, n);
        return 0;
    }

    int endPointer = 2;
    int storedLength = 0;
    int currentLength = 2;

    for (int i = 2; i < n; ++i) {

        if (flowers[i] == flowers[i-1] && flowers[i-1] == flowers[i-2]) {
            if (currentLength > storedLength) {
                storedLength = currentLength;
                endPointer = i;
            }
            currentLength = 1;
        }
        currentLength++;
    }

    int beginIndex, endIndex;
    if (storedLength >= currentLength) {
        endIndex = endPointer;
        beginIndex = endIndex - storedLength + 1;
    } else {
        endIndex = n;
        beginIndex = endIndex - currentLength + 1;
    }
    printf("%d %d", beginIndex, endIndex);

    return 0;
}
