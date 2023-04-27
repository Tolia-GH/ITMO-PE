#include <iostream>
#include <deque>
#include <queue>

using namespace std;

int n = 0;
string line;
string i_num;
deque<int> left_part(0);
deque<int> right_part(0);
queue<int> answer;

int main()
{

    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n;
    cin.get();

    for (int i = 0; i < n; i++)
    {
        getline(cin, line);
        if (left_part.size() < right_part.size() && !right_part.empty())
        {
            left_part.push_back(right_part.front());
            right_part.pop_front();
        }

        if ((char)line[0] == '+')
        {
            i_num = line.substr(2);
            right_part.push_back(stoi(i_num));
        }
        else if (line[0] == '*')
        {
            i_num = line.substr(2);
            right_part.push_front(stoi(i_num));
        }
        else if (!left_part.empty())
        {
            answer.push(left_part.front());
            left_part.pop_front();
        }
        else
        {
            answer.push(right_part.front());
            right_part.pop_front();
        }
    }
    n = answer.size();
    for (int i = 0; i < n; i++)
    {
        cout << answer.front() << endl;
        answer.pop();
    }
}