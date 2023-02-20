#include <cstdio>
#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
 
#define MAX 100005
 
using namespace std;
 
// cost, pos
queue<pair<int, int>> q;
 
int trace[MAX];
 
int main()
{
    int start, finish;
    int ans;
 
    vector<int> vc;
 
    scanf("%d %d", &start, &finish);
 
    memset(trace, -1, sizeof(trace));
 
    q.push(make_pair(0, start));
 
    while (!q.empty())
    {
        int cost = q.front().first;
        int here = q.front().second;
 
        q.pop();
 
        // 현재 위치가 도착점에 도달했을 때
        if (here == finish)
        {
            // 지금까지 수행 횟수를 ans에 저장
            // (결국 몇번만에 갔는지 의미)
            ans = cost;
            break;
        }
 
        // 이 위치를 아직 와본적이 없다면
        // 큐에 넣어주고 다음 위치에 이전 위치의 자취를 남긴다.
        if (here * 2 <= MAX && trace[here * 2] == -1)
        {
            q.push(make_pair((cost + 1), here * 2));
            trace[here * 2] = here;
        }
 
        if (here + 1 <= MAX && trace[here + 1] == -1)
        {
            q.push(make_pair((cost + 1), here + 1));
            trace[here + 1] = here;
        }
 
        if (here - 1 >= 0 && trace[here - 1] == -1)
        {
            q.push(make_pair((cost + 1), here - 1));
            trace[here - 1] = here;
        }
    }
 
    printf("%d\n", ans);
 
    // 끝점부터 시작점까지 갈 때 까지 vector에 push한다.
    int pos = finish;
    while (pos != start)
    {
        vc.push_back(trace[pos]);
        pos = trace[pos];
    }
 
    // 역순 출력(스택 방식)
    for (int i = vc.size() - 1; i >= 0; i--)
        printf("%d ", vc[i]);
 
    printf("%d", finish);
 
    return 0;
}