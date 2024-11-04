#include <iostream>
#include <unordered_map>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int N, M;
    cin >> N;
    unordered_map<int, int> m;

    while (N--)
    {
        int num;
        cin >> num;
        m[num]++;
    }
    cin >> M;

    while (M--)
    {
        int num;
        cin >> num;
        cout << m[num] << ' ';
    }
}