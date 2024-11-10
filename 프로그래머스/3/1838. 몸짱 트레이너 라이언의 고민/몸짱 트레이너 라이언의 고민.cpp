#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;
struct Point
{
    int x, y;
    Point(int x, int y) : x(x), y(y) {}
};
// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
int solution(int n, int m, vector<vector<int>> timetable) {
    vector<int> preSum(722, 0);

    // 1. 가장 많이 겹치는 회원수 구하기
    for (int i = 0; i < m; i++)
    {
        preSum[timetable[i][0] - 600]++;
        preSum[timetable[i][1] - 600 + 1]--;
    }

    int sum = 0;
    int maxOverlap = 0; // 가장 많이 겹치는 회원 수
    for (int i = 0; i <= 720; i++)
    {
        sum += preSum[i];
        preSum[i] = sum;
        maxOverlap = std::max(maxOverlap, preSum[i]);
    }

    if (maxOverlap <= 1)
        return 0;

    // 2. 가능한 거리 순회하며 max만큼 배치할 수 있으면 리턴
    vector<Point> list;
    for (int dist = 2 * (n - 1); dist >= 1; dist--)
    {
        // 첫번째 row의 시작지점을 변경
        for (int sy = 0; sy < n; sy++)
        {
            list.clear();
            int cnt = 0;
            // 맵 전체 순회
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (i == 0 && j < sy)
                        continue;

                    // 해당 위치에 회원 들어갈 수 있는지 확인
                    bool flag = true;
                    for (const Point &p : list)
                    {
                        if (abs(p.x - i) + abs(p.y - j) >= dist)
                            continue;
                        flag = false;
                        break;
                    }
                    if (flag)
                    {
                        if (++cnt == maxOverlap)
                            return dist;
                        list.emplace_back(i, j);
                    }
                }
            }
        }
    }
    return 0;

}