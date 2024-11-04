#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, C;
    cin >> N >> C;
    vector<int> arr;
    while (N--)
    {
        int num;
        cin >> num;
        arr.push_back(num);
    }

    int left = 0, right = 2e9;
    sort(arr.begin(), arr.end());

    while (left <= right)
    {
        int mid = left + (right - left) / 2;
        int cnt = 1;
        int cur = arr[0];

        for (int i = 1; i < arr.size(); i++)
        {
            if (arr[i] - cur >= mid)
            {
                cur = arr[i];
                cnt++;
            }
        }

        if (cnt >= C)
        {
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }
    cout << left - 1;
}