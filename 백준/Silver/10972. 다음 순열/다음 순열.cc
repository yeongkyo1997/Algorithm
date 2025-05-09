#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;
    vector<int> vec(N, 0);
    for (int i = 0; i < N; i++)
    {
        cin >> vec[i];
    }

    bool hasNext = next_permutation(vec.begin(), vec.end());

    if (hasNext)
    {
        for (int num : vec)
        {
            cout << num << " ";
        }
    }
    else
    {
        cout << "-1";
    }
}