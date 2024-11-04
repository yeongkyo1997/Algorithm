#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int binarySearch(vector<int> &arr, int num)
{
    int left = 0;
    int right = arr.size() - 1;

    while (left <= right)
    {
        int mid = left + (right - left) / 2;

        if (arr[mid] == num)
            return 1;
        else if (arr[mid] > num)
        {
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }
    return 0;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N;
    cin >> N;
    vector<int> arr;

    while (N--)
    {
        int num;
        cin >> num;
        arr.push_back(num);
    }

    int M;
    cin >> M;
    sort(arr.begin(), arr.end());
    while (M--)
    {
        int num;
        cin >> num;
        cout << binarySearch(arr, num) << '\n';
    }
}