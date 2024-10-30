#include <iostream>
#include <queue>
#include <sstream>
#include <string>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    ostringstream oss;
    int N;

    cin >> N;
    queue<int> q;
    for (int i = 0; i < N; i++)
    {
        string cmd;
        cin >> cmd;

        if (cmd == "push")
        {
            int X;
            cin >> X;
            q.push(X);
        }
        else if (cmd == "pop")
        {
            if (q.empty())
                oss << -1 << "\n";
            else
            {
                oss << q.front() << "\n";
                q.pop();
            }
        }
        else if (cmd == "size")
        {
            oss << q.size() << "\n";
        }
        else if (cmd == "empty")
        {
            oss << (int)q.empty() << "\n";
        }
        else if (cmd == "front")
        {
            if (q.empty())
                oss << -1 << "\n";
            else
                oss << q.front() << "\n";
        }
        else if (cmd == "back")
        {
            if (q.empty())
                oss << -1 << "\n";
            else
                oss << q.back() << "\n";
        }
    }
    cout << oss.str();
}