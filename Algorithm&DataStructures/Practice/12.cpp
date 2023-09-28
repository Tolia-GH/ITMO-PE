//
// Created by 2398768715 on 2023/4/24.
//
#include <iostream>
#include <algorithm>
#define MAX 100001


int n, k;
int num[150001];
std::pair<int,int> min;

std::pair<int,int> quickFindMin(int left, int right) {
    if (left == right) {//when subset only contains one element
        return std::make_pair(num[left],left);
    } else if (left == right - 1) {//when subset only contains two elements
        return num[left] > num[right] ? std::make_pair(num[right],right) : std::make_pair(num[left],left);
    } else {//when subset contains more than two elements
        int mid = (left + right) / 2;//divide the set into two part

        std::pair<int,int> left_part = quickFindMin(left, mid);//recoil left part
        std::pair<int,int> right_part = quickFindMin(mid + 1, right);//recoil right part

        return left_part.first < right_part.first ? left_part : right_part;//compare left part and right part
    }
}

int findPartMin(int i) {
    if (i - 1 == min.second) {
//        minValue = MAX;
//        for (int j = i; j < i+k; ++j) {
//            if (num[j] < minValue) {
//                minValue = num[j];
//                minIndex = j;
//            }
//        }
        min = quickFindMin(i,i+k-1);
        return min.first;
    } else {
        if (min.first > num[i+k-1]) {
            min.first = num[i+k-1];
            min.second = i+k-1;
        }

        return min.first;
    }
}

int main() {
    std::cin >> n >> k;
    for (int i = 0; i < n; ++i) {
        std::cin >> num[i];
    }

//    minValue = MAX;
//    for (int i = 0; i < n; ++i) {//find the minValue and minIndex of the first part
//        if (num[i] < minValue) {
//            minValue = num[i];
//            minIndex = i;
//        }
//    }
//    cout<<minValue<<" ";
    min = quickFindMin(0,k-1);
    std::cout<<min.first<<" ";

    for (int i = 1; i <= n-k; ++i) {
        std::cout<<findPartMin(i)<<" ";
    }
}