//
// Created by 2398768715 on 2023/4/24.
//
#include <iostream>
#include <vector>
#include <set>

using namespace std;

int on_ground [100000] = {0};//下标对应序号
set<pair<int,int>> group_on_ground;//position
vector<int> peter_want;
int solve(int n, int k, int p)
{
    int result = 0;
    vector<vector<int>> positions(n+1);
    for (int i = 0; i <= n; ++i){
        positions[i].emplace_back(p);
    }
    for(int i = p - 1 ; i >=0; i--){
        //倒过来记录顺序
        positions[peter_want[i]].emplace_back(i);
    }
    for (int i = 0; i < p; i++)
    {
        positions[peter_want[i]].pop_back();
        if (group_on_ground.count({i, peter_want[i]}))
        {
            group_on_ground.erase({i, peter_want[i]});
            group_on_ground.emplace(positions[peter_want[i]].back(), peter_want[i]);
            continue;
        }
        result++;
        if (group_on_ground.size() == k){
            group_on_ground.erase(--group_on_ground.end());
        }
        group_on_ground.emplace(positions[peter_want[i]].back(), peter_want[i]);
    }
    return result;
}

int main()
{
    // n - all cars, p - how many cars peter wants, k - biggest amount of car can be put on ground
    int n, k, p;
    cin >> n >> k >> p;
    for (int i = 0; i < p; i++)
    {
        int j;
        cin >> j;
        peter_want.emplace_back(j);
    }
    int result = solve(n,k,p);
    cout << result<< endl;
    return 0;
}