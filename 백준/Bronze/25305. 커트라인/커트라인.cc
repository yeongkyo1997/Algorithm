#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int N, k;
    cin >> N >> k;

    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end(), greater<int>());

    cout << arr[k - 1];
}