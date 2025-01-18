#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct Food
{
    long long time;
    int index;
};

struct Compare
{
    bool operator()(Food a, Food b)
    {
        if (a.time == b.time)
            return a.index > b.index;
        return a.time > b.time;
    }
};

int solution(vector<int> food_times, long long k)
{

    int n = food_times.size();

    priority_queue<Food, vector<Food>, Compare> pq;
    for (int i = 0; i < n; i++)
    {
        pq.push(Food{(long long)food_times[i], i + 1});
    }

    long long previous = 0;

    long long length = n;

    long long current;

    while (!pq.empty())
    {

        current = pq.top().time;

        long long diff = current - previous;
        if (diff != 0)
        {

            long long spend = diff * length;
            if (spend <= k)
            {
                k -= spend;
                previous = current;

                while (!pq.empty() && pq.top().time == current)
                {
                    pq.pop();
                    length--;
                }
                if (length == 0)
                {
                    return -1;
                }
            }
            else
            {
                break;
            }
        }
        else
        {

            while (!pq.empty() && pq.top().time == current)
            {
                pq.pop();
                length--;
                if (length == 0)
                {
                    return -1;
                }
            }
        }
    }

    if (length == 0)
    {
        return -1;
    }

    vector<Food> remaining;
    while (!pq.empty())
    {
        remaining.push_back(pq.top());
        pq.pop();
    }
    sort(remaining.begin(), remaining.end(), [&](const Food &a, const Food &b) -> bool
         { return a.index < b.index; });

    return remaining[k % length].index;
}