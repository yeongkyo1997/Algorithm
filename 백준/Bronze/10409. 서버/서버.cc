#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n, T;
    cin >> n >> T;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    int sum = 0;
    int result = 0;

    for (int i = 0; i < n; ++i)
    {
        sum += arr[i];
        if (sum > T)
            break;
        result += 1;
    }
    cout << result;
}