#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);

    int M;
    cin >> M;
    int s = 0;

    while (M--)
    {
        string command;
        cin >> command;

        if (command == "add")
        {
            int num;
            cin >> num;
            s |= 1 << num;
        }
        else if (command == "remove")
        {
            int num;
            cin >> num;
            s &= ~(1 << num);
        }
        else if (command == "check")
        {
            int num;
            cin >> num;
            if (s & (1 << num))
                cout << "1\n";
            else
                cout << "0\n";
        }
        else if (command == "toggle")
        {
            int num;
            cin >> num;
            if (s & (1 << num))
                s &= ~(1 << num);
            else
                s |= (1 << num);
        }
        else if (command == "all")
        {
            s = (1 << 21) - 1;
        }
        else if (command == "empty")
        {
            s = 0;
        }
    }
}