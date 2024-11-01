#include <iostream>
#include <sstream>
#include <deque>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    ostringstream oss;
    int N;
    cin >> N;
    deque<int> dq;

    while (N-- != 0)
    {
        int q, X;
        cin >> q;

        switch (q)
        {
        case 1:
            cin >> X;
            dq.push_front(X);
            break;

        case 2:
            cin >> X;
            dq.push_back(X);
            break;

        case 3:
            if (dq.empty())
                oss << -1 << '\n';
            else
            {
                oss << dq.front() << '\n';
                dq.pop_front();
            }
            break;

        case 4:
            if (dq.empty())
                oss << -1 << '\n';
            else
            {
                oss << dq.back() << '\n';
                dq.pop_back();
            }
            break;

        case 5:
            oss << dq.size() << '\n';
            break;

        case 6:
            oss << (int)dq.empty() << '\n';
            break;

        case 7:
            oss << (dq.empty() ? -1 : dq.front()) << '\n';
            break;

        case 8:
            oss << (dq.empty() ? -1 : dq.back()) << '\n';
            break;
        }
    }

    cout << oss.str();
}