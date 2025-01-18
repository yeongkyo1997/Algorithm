#include <string>
#include <vector>

using namespace std;

int solution(int n)
{

    vector<long long> C(n + 1, 0);
    C[0] = 1;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            C[i] += C[j] * C[i - 1 - j];
        }
    }

    return (int)C[n];
}