#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M;
    cin >> N >> M;
    int result = 0;
    vector<int> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            for (int k = j + 1; k < N; k++)
            {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum <= M)
                {
                    result = max(result, sum);
                }
            }
        }
    }
    cout << result;
}