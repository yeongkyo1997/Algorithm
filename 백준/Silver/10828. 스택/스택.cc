#include <iostream>
#include <stack>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    stack<int> s;

    while (N--)
    {
        string command;
        cin >> command;
        if (command == "push")
        {
            int X;
            cin >> X;
            s.push(X);
        }
        else if (command == "pop")
        {
            if (s.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << s.top() << '\n';
                s.pop();
            }
        }
        else if (command == "size")
        {
            cout << s.size() << '\n';
        }
        else if (command == "empty")
        {
            if (s.empty())
            {
                cout << "1\n";
            }
            else
            {
                cout << "0\n";
            }
        }
        else if (command == "top")
        {
            if (s.empty())
            {
                cout << "-1\n";
            }
            else
            {
                cout << s.top() << '\n';
            }
        }
    }
}