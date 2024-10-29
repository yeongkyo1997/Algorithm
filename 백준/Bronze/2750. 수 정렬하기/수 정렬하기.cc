#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void quickSort(vector<int> &arr, int start, int end)
{
    if (start >= end)
        return;

    if (start < end)
    {
        int i = start - 1;
        int j = end + 1;
        int pivot = arr[(start + end) / 2];

        while (i < j)
        {
            while (arr[++i] < pivot)
            {
            }
            while (arr[--j] > pivot)
            {
            }

            if (i >= j)
                break;

            swap(arr[i], arr[j]);
        }
        quickSort(arr, start, i - 1);
        quickSort(arr, j + 1, end);
    }
}

int main()
{
    int N;
    cin >> N;
    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    quickSort(arr, 0, N - 1);

    for (auto a : arr)
    {
        cout << a << "\n";
    }
}