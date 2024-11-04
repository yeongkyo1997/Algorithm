#include <iostream>
#include <vector>

typedef long long ll;

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M;
    cin >> N >> M;
    vector<int> arr;

    while (N--)
    {
        int num;
        cin >> num;
        arr.push_back(num);
    }

    ll left = 0, right = 1e18;
    ll result = 0;
    while (left <= right)
    {
        ll mid = (left + right) / 2;
        ll total = 0;
        for (auto a : arr)
        {
            if (a >= mid)
            {
                total += a - mid;
            }
        }
        if (total >= M)
        {
            left = mid + 1;
            result = mid;
        }
        else
        {
            right = mid - 1;
        }
    }

    cout << result;
}