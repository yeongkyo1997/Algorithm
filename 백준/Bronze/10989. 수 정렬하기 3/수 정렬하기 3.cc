#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    unordered_map<int, int> m;

    while (N--)
    {
        int num;
        cin >> num;
        if (m.find(num) == m.end())
            m[num] = 0;
        m[num]++;
    }

    for (int i = 0; i <= 10000; i++)
    {
        for (int j = 0; j < m[i]; j++)
        {
            cout << i << '\n';
        }
    }
}