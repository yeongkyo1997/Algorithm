#include <vector>

using namespace std;

int solution(vector<int> a)
{
    int n = a.size();
    if (n == 0)
        return 0;

    vector<bool> can_be_last(n, false);

    int min_so_far = a[0];
    can_be_last[0] = true;
    for (int i = 1; i < n; ++i)
    {
        if (a[i] < min_so_far)
        {
            can_be_last[i] = true;
            min_so_far = a[i];
        }
    }

    min_so_far = a[n - 1];
    can_be_last[n - 1] = true;
    for (int i = n - 2; i >= 0; --i)
    {
        if (a[i] < min_so_far)
        {
            can_be_last[i] = true;
            min_so_far = a[i];
        }
    }

    int count = 0;
    for (bool b : can_be_last)
    {
        if (b)
            count++;
    }

    return count;
}