#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, M;
    cin >> N >> M;
    vector<long long> A(N);
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    sort(A.begin(), A.end());
    int left = 0, right = 0;
    long long min_diff = LLONG_MAX;
    while (right < N)
    {
        if (left >= N)
        {
            break;
        }
        if (A[right] - A[left] >= M)
        {
            if (A[right] - A[left] < min_diff)
            {
                min_diff = A[right] - A[left];
            }
            left++;
        }
        else
        {
            right++;
        }
    }
    cout << min_diff << endl;
    return 0;
}