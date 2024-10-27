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

    vector<int> vec;
    for (int i = 1; i <= N; i++)
    {
        vec.push_back(i);
    }
    do
    {
        for (int v : vec)
        {
            cout << v << " ";
        }
        cout << "\n";
    } while (next_permutation(vec.begin(), vec.end()));
}