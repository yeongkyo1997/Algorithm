#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool isPossible(long long mid, const vector<int> &rocks, int n, int distance)
{
    int removed = 0;
    long long previous = 0;

    for (auto rock : rocks)
    {
        if ((rock - previous) < mid)
        {

            removed++;
            if (removed > n)
                return false;
        }
        else
        {

            previous = rock;
        }
    }

    if ((distance - previous) < mid)
    {
        removed++;
    }

    return removed <= n;
}

long long solution(int distance, vector<int> rocks, int n)
{

    sort(rocks.begin(), rocks.end());

    long long left = 1;
    long long right = distance;
    long long answer = 0;

    while (left <= right)
    {
        long long mid = (left + right) / 2;

        if (isPossible(mid, rocks, n, distance))
        {

            answer = mid;
            left = mid + 1;
        }
        else
        {

            right = mid - 1;
        }
    }

    return answer;
}