#include <iostream>

int main() {
    int n;//amount of flowers
    scanf("%d", &n);

    int flowers[n];//array of flowers

    for (int i = 0; i < n; ++i) {//input flowers
        scanf("%d", &flowers[i]);
    }

    if (n < 3) {//for flowers less than 3
        printf("%d %d", 1, n);
        return 0;
    }

    int endPointer = 2;
    int storedLength = 0;
    int currentLength = 2;

    for (int i = 2; i < n; ++i) {//loop begin with 3-rd flower

        if (flowers[i] == flowers[i-1] && flowers[i-1] == flowers[i-2]) {//check if there are 3 same flowers together
            if (currentLength > storedLength) {//update max length of flowers
                storedLength = currentLength;
                endPointer = i;//record last flower's position
            }
            currentLength = 1;//count length from 1 again
        }
        currentLength++;
    }

    int beginIndex, endIndex;
    if (storedLength >= currentLength) {//check and get the max length of flowers again
        endIndex = endPointer;//record last flower's position
        beginIndex = endIndex - storedLength + 1;//get first flower's position
    } else {
        endIndex = n;
        beginIndex = endIndex - currentLength + 1;
    }
    printf("%d %d", beginIndex, endIndex);//print answer

    return 0;
}
