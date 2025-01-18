#include <string>
#include <vector>
#include <queue>
#include <cmath>
using namespace std;

long long solution(int n, vector<int> works)
{

    priority_queue<int, vector<int>, less<int>> maxHeap;

    for (int w : works)
    {
        maxHeap.push(w);
    }

    while (n > 0 && !maxHeap.empty())
    {
        int topWork = maxHeap.top();
        maxHeap.pop();

        if (topWork == 0)
        {

            break;
        }

        topWork -= 1;
        maxHeap.push(topWork);
        n--;
    }

    long long answer = 0;
    while (!maxHeap.empty())
    {
        long long w = (long long)maxHeap.top();
        maxHeap.pop();
        answer += w * w;
    }

    return answer;
}
