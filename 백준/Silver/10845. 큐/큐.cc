#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    queue<int> q;
    while (N--)
    {
        string command;
        cin >> command;

        if (command == "push")
        {
            int num;
            cin >> num;
            q.push(num);
        }
        else if (command == "pop")
        {
            if (q.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << q.front() << '\n';
                q.pop();
            }
        }
        else if (command == "size")
        {
            cout << q.size() << '\n';
        }
        else if (command == "empty")
        {
            if (q.empty())
            {
                cout << 1 << '\n';
            }
            else
            {
                cout << 0 << '\n';
            }
        }
        else if (command == "front")
        {
            if (q.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << q.front() << '\n';
            }
        }
        else if (command == "back")
        {
            if (q.empty())
            {
                cout << -1 << '\n';
            }
            else
            {
                cout << q.back() << '\n';
            }
        }
    }
}