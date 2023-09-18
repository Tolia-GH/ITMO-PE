#include <iostream>
#include <map>
#include <stack>
#include <vector>

using namespace std;
bool isNumber(const string str)
{
    for(int i = 0 ; i < str.size(); i++){
        if(i==0){
            if(str[i]!='-'&&!isdigit(str[i])){
                return false;
            }
        }else{
            if(!isdigit(str[i])){
                return false;
            }
        }
    }
    return true;
}

int main(){
    map<string,stack<long>> maps;
    vector<vector<string>> remove;
    vector<string> start;
    remove.emplace_back(start);
    string s;
    while(getline(cin,s)){
        if(!s.compare("{")){
            vector<string> new_remove;
            remove.push_back(new_remove);
        }else if(!s.compare("}")){
            for(auto i: remove.back()){
                if(maps.find(i)->second.size()<=1){
                    maps.erase(i);
                }else{
                    maps[i].pop();
                }
            }
            remove.pop_back();
        }else{
            size_t position = s.find("=",0);
            string sub1 = s.substr(0,position);
            string sub2 = s.substr(position+1,s.size()-position-1);
            //a = 1
            if(isNumber(sub2)){
                maps[sub1].emplace(stol(sub2));
                remove.back().emplace_back(sub1);
            }
                //a=b
            else{
                remove.back().emplace_back(sub1);
                if(!maps[sub2].empty()){
                    long result =maps[sub2].top();
                    maps[sub1].emplace(result);
                    cout<<result<<endl;
                }else{
                    maps[sub1].emplace(0);
                    cout<<0<<endl;
                }
            }
        }
    }
    return 0;
}
