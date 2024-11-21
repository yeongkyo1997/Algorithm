#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(NULL);
    cin.tie(NULL);
    cout.tie(NULL);
    auto cmp = [](int left, int right)
    {
        if (abs(left) == abs(right))
            return left > right;
        return abs(left) > abs(right);
    };
    priority_queue<int, vector<int>, decltype(cmp)> pq(cmp);

    int N;
    cin >> N;
    while (N--)
    {
        int x;
        cin >> x;
        if (x == 0)
        {
            if (pq.empty())
                cout << "0\n";
            else
            {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
        else
        {
            pq.push(x);
        }
    }
}