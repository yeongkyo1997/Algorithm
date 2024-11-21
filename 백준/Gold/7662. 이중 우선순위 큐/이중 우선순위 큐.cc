#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    multiset<int> s;
    while (T--)
    {
        s.clear();
        int Q;
        cin >> Q;
        while (Q--)
        {
            char c;
            cin >> c;
            if (c == 'I')
            {
                int x;
                cin >> x;
                s.insert(x);
            }
            else
            {
                int x;
                cin >> x;
                if (s.empty())
                    continue;
                if (x == -1)
                {
                    s.erase(s.begin());
                }
                else
                {
                    s.erase(--s.end());
                }
            }
        }
        if (s.empty())
            cout << "EMPTY\n";
        else
        {
            cout << *s.rbegin() << " " << *s.begin() << '\n';
        }
    }
}