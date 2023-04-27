//
// Created by 2398768715 on 2023/3/16.
//
#include "cstdio"
#include "cstring"
#include "cctype"
#include "cstdlib"
#include "iostream"

using namespace std;

int nAnimal = 0;//number of animals
int nTrap = 0;//number of traps
int trap[50001];//record the index of animals that is caught by each trap

/*
 * A self created Stack for Storing information when handling problem
 * everytime input a character, we push it on the top of stack
 * only if this character match the last element on top, then pop these two element out of stack and record their index in `trap[]`
 *
 * Example input "aGBbcCgA":
 * | characters | a | G | B | b | c | C | g | A |
 * | index      | 1 | 1 | 2 | 2 | 3 | 3 | 4 | 4 |
 * Step 1: push 'a' into stack
 * | characters[] | a |
 * | index[]      | 1 |
 * Step 2: push 'G' into stack
 * | characters[] | a | G |
 * | index[]      | 1 | 1 |
 * Step 3: push 'B' into stack
 * | characters[] | a | G | B |
 * | index[]      | 1 | 1 | 2 |
 * Step 4: push 'b' into stack
 * | characters[] | a | G | B | b |
 * | index[]      | 1 | 1 | 2 | 2 |
 * Step 5: pop 'B' and 'b' out of stack, record trap[2] = 2
 * | characters[] | a | G |
 * | index[]      | 1 | 1 |
 * Step 6: push 'c' into stack
 * | characters[] | a | G | c |
 * | index[]      | 1 | 1 | 3 |
 * Step 6: push 'C' into stack
 * | characters[] | a | G | c | C |
 * | index[]      | 1 | 1 | 3 | 3 |
 * Step 7: pop 'c' and 'C' out of stack, record trap[3] = 3
 * | characters[] | a | G |
 * | index[]      | 1 | 1 |
 * Step 8: push 'g' into stack
 * | characters[] | a | G | g |
 * | index[]      | 1 | 1 | 4 |
 * Step 9: pop 'G' and 'g' out of stack, record trap[1] = 4
 * | characters[] | a |
 * | index[]      | 1 |
 * Step 10: push 'A' into stack
 * | characters[] | a | A |
 * | index[]      | 1 | 4 |
 * Step 11: pop 'a' and 'A' out of stack, record trap[4] = 1
 * | characters[] |
 * | index[]      |
 * END
 *
 * stack is empty, so the answer is "Possible"
 * and the `trap[]` is: 4, 2, 3, 1
 */
struct Stack {
    int stackPointer;//point to the top of stack
    char characters[100001];//stack content for character
    int index[100001];//stack content for index of Animals and Traps

    void init() {//create an empty stack
        stackPointer = 0;
    }

    void push(char c) {//push character into stack
        characters[++stackPointer] = c;
        if (islower(c)) {//if we push an animal into stack
            nAnimal++;
            index[stackPointer] = nAnimal;//store the index of the animal
        } else if (isupper(c)) {//if we push a trap into stack
            nTrap++;
            index[stackPointer] = nTrap;//store the index of trap
        }
    }

    int indexAnimal, indexTrap;
    void pop() {//pop out the couple of animal and trap and record their index in `trap[]`
        if (isupper(characters[stackPointer])) {
            indexTrap = index[stackPointer];
            indexAnimal = index[stackPointer - 1];
        } else if (islower(characters[stackPointer])) {
            indexTrap = index[stackPointer - 1];
            indexAnimal = index[stackPointer];
        }
        trap[indexTrap] = indexAnimal;

        characters[stackPointer - 1] = characters[stackPointer] = '\0';
        index[stackPointer - 1] = index[stackPointer] = 0;
        stackPointer -= 2;
    }


    char c;
    void check() {
        if (isalpha(characters[stackPointer])) {
            if (isupper(characters[stackPointer])) {
                c = tolower(characters[stackPointer]);
            } else if (islower(characters[stackPointer])) {
                c = toupper(characters[stackPointer]);
            }
            if (characters[stackPointer - 1] == c) {
                this->pop();
            }
        } else {
            exit(1);//input error
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
        for (int i = 1; i<= 100000 ;++i) {
            if (trap[i] == 0) {
                return 0;
            }
            cout << trap[i] << " ";
        }
    } else {
        cout<<"Impossible";
    }
}