#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <limits>
#include <cmath>

using namespace std;

int total(vector<int> &vec)
{
    int ret = 0;
    for (int i = 0; i < vec.size() - 1; i++)
    {
        ret += abs(vec[i] - vec[i + 1]);
    }
    return ret;
}

int main()
{
    int N;
    cin >> N;
    vector<int> vec(N);
    int result = -INFINITY;
    for (int i = 0; i < N; i++)
    {
        cin >> vec[i];
    }
    sort(vec.begin(), vec.end());

    do
    {
        int val = total(vec);
        result = max(result, val);
    } while (next_permutation(vec.begin(), vec.end()));
    cout << result;
}