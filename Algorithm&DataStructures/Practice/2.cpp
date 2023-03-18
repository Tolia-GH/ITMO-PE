//
// Created by 2398768715 on 2023/3/16.
//
#include "cstdio"
#include "cstring"
#include "cctype"
#include "cstdlib"
#include "iostream"

using namespace std;

int nAnimal = 0;
int nTrap = 0;
int trap[50001];

struct Stack {
    int stackPointer;
    char characters[100001];

    void init() {//create an empty stack
        stackPointer = 0;
    }

    void push(char c) {//push character into stack
        characters[++stackPointer] = c;
        if (islower(c)) {
            nAnimal++;
        } else if (isupper(c)) {
            nTrap++;
        }
    }

    void pop() {
        characters[stackPointer - 1] = characters[stackPointer] = '\0';
        stackPointer -= 2;

        trap[nTrap] = nAnimal;
        nTrap--;
        //nAnimal--;
    }


    char c;
    void check() {
        for (int i = 1; i < stackPointer; ++i) {
            if (isalpha(characters[stackPointer])) {
                if (isupper(characters[stackPointer])) {
                    c = tolower(characters[stackPointer]);
                } else if (islower(characters[stackPointer])) {
                    c = toupper(characters[stackPointer]);
                }
                if (characters[i] == c) {
                    this->pop();
                }
            } else {
                exit(1);//input error
            }
        }
    }

    bool isEmpty() {
        return stackPointer == 0;
    }
}stack;

int main() {
    stack.init();//initialize new stack

    char c;
    while ((c = getchar())) {
        //n++;
        if (c == '\n') {
            break;
        }
        stack.push(c);
        stack.check();
    }
    if (stack.isEmpty()) {
        cout<<"Possible"<<endl;
        for (int i = 1; i <= 100000; i++) {
            if (trap[i] == 0) {
                return 0;
            }
            cout << trap[i] << " ";
        }
    } else {
        cout<<"Impossible";
    }
}