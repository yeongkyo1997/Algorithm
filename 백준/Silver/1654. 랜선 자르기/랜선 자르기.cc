#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int K, N;
    cin >> K >> N;
    vector<ll> arr;

    while (K--)
    {
        ll num;
        cin >> num;
        arr.push_back(num);
    }
    ll left = 1, right = 1e10;
    ll result = 0;

    while (left <= right)
    {
        ll mid = (left + right) / 2;
        ll cnt = 0;

        for (int i = 0; i < arr.size(); i++)
        {
            cnt += arr[i] / mid;
        }

        if (cnt >= N)
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