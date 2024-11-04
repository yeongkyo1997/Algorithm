#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    vector<int> arr;
    while (N != 0)
    {
        arr.push_back(N % 10);
        N /= 10;
    }

    sort(arr.begin(), arr.end(), greater<int>());

    for (auto a : arr)
    {
        cout << a;
    }
}