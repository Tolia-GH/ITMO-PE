//
// Created by 2398768715 on 2023/3/16.
//
#include <iostream>
#include <cstring>
#include <stdbool.h>
#include <algorithm>
using namespace std;
class Counter{
public:
    int balance[26] = {0};
    void resetBalacne(){
        for(int i= 0 ; i < 26 ; i++) {
            balance[i] = 0;
        }
    }
    //should be upper
    void addBalance(char c){
        balance[c-65] = balance[c-65]+1;
    }
    //should be lower
    void minBalance(char c){
        balance[c-97] = balance[c-97] - 1;
    }
    bool isBalanceZero(){
        for(int i = 0; i<26; i++){
            if(balance[i] != 0){
                return false;
            }
        }
        return true;
    }
};

int main()
{
    int a = 0;
    string str1;
    scanf("%s", &str1);

    int inputLength = str1.size();
    int animalsIndexInString[inputLength/2];
    for(int i = 0; i < inputLength;i++){
        if(islower(str1[i])){
            animalsIndexInString[a] = i;
            a++;
        }
    }
    int lines [inputLength];
    bool possible = true;
    bool capature[200000] = {false};
    int resultIndexSet[100000] = {0};
    int pointerOfSet = 0;
    for(int i = 0 ; i < inputLength&&possible; i++){
        if(!capature[i]){
            bool end = false;
            Counter counter;
            if(isupper(str1[i])){//this situation is started a trap
                counter.addBalance(str1[i]);
                for(int j = i+1 ; j<inputLength&&!end; j++){
                    if(!capature[j]){
                        if(isupper(str1[j])){
                            counter.addBalance(str1[j]);
                        }else{
                            counter.minBalance(str1[j]);
                            if(toupper(str1[j])==str1[i]){
                                if(counter.isBalanceZero()){
                                    end=true;//break
                                    lines[i] = j;//i trap
                                    resultIndexSet[pointerOfSet] = i;
                                    pointerOfSet++;
                                    capature[i] = true;
                                    capature[j] = true;
                                }
                            }
                        }
                    }
                }
            }else{//this situation is started at an animal
                counter.minBalance(str1[i]);
                for(int j = i+1; j < inputLength&&!end; j++){
                    if(!capature[j]){
                        if(isupper(str1[j])){
                            counter.addBalance(str1[j]);
                            if(tolower(str1[j])==str1[i]){
                                if(counter.isBalanceZero()){
                                    end = true;//break
                                    lines[j] = i;
                                    resultIndexSet[pointerOfSet] = j;
                                    pointerOfSet++;
                                    capature[i] = true;
                                    capature[j] = true;
                                }
                            }
                        }else{
                            counter.minBalance(str1[j]);
                        }
                    }
                }
            }
            //if end!=true, means that go to end of all but balance still !=0
            if(!end){
                possible = false;
            }
        }
    }
    if(!possible){
        cout<<"Impossible";
    }else{
        cout<<"Possible"<<endl;
        sort(resultIndexSet,resultIndexSet+inputLength/2);
        for(int i = 0; i < inputLength/2 ;i++){
            for(int j = 0 ; j < inputLength/2 ; j++){
                if(animalsIndexInString[j] == lines[resultIndexSet[i]]){
                    cout<<j+1<<" ";
                }
            }
        }
    }
    cout<<endl;
    return 0;
}