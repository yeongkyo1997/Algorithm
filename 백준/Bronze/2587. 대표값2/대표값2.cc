#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    int N = 5;
    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    int total = 0;

    for (auto a : arr)
    {
        total += a;
    }
    cout << total / N << '\n';
    sort(arr.begin(), arr.end());
    cout << arr[arr.size() / 2];
}