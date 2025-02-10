#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    long long sumA = 0, sumB = 0, sumProduct = 0;
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        sumA += a;
        sumB += b;
        sumProduct += (long long)a * b;
    }

    long long answer = sumA * sumB - sumProduct;
    cout << answer << "\n";

    return 0;
}