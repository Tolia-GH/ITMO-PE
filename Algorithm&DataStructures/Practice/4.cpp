//
// Created by 2398768715 on 2023/3/16.
//
#include <iostream>
#include <stdio.h>
using namespace std;

int main()
{
    int a, b, c, d, k;
    //number of bacteria,
    // number of bacterias created by 1 bacteria everyday,
    // every day usage of bacteria
    // container capacity of bacterias
    // search day k

    //scanf("%d%d%d%d%d", &a, &b, &c, &d, &k);
    cin >> a >> b >> c >> d >> k;

    //for every day i
    for (int i = 0; i < k; i++){
        a = a * b;//every day changes
        a -= min(a, c);//every day usage for experiment

        if (a == 0) {//experiment ends
            break;
        } else if (a > d) {//experiment continue and bacterias overflow
            a = d;
            break;
        } else if (a == a * b - min(a * b, c)) {//experiment continue but bacterias come to balance
            break;
        }
    }

    //printf("%d", a);
    cout << a << endl;

    return 0;
}