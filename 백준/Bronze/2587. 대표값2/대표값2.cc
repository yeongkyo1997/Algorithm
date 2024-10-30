#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    const int N = 5;
    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());
    int sum = 0;
    for (auto a : arr)
    {
        sum += a;
    }

    cout << sum / arr.size() << "\n";
    cout << arr[arr.size() / 2];
}