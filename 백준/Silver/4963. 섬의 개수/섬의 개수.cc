#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

#define MAXSIZE 50

int map[MAXSIZE][MAXSIZE];
bool visited[MAXSIZE][MAXSIZE];

int dir[8][2] = {
    {-1, -1},
    {-1, 0},
    {-1, 1},
    {0, -1},
    {0, 1},
    {1, -1},
    {1, 0},
    {1, 1}};

int main() {
    int w, h;

    while (1) {
        cin >> w >> h;

        if (w == 0 && h == 0)
            break;

        memset(map, 0, sizeof(map));

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> map[i][j];
            }
        }

        queue<pair<int, int>> Q;

        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0 || MAXSIZE <= i || MAXSIZE <= j)
                    continue;

                Q.push({i, j});
                map[i][j] = 0;

                while (!Q.empty()) {
                    int curH = Q.front().first;
                    int curW = Q.front().second;
                    Q.pop();

                    for (int index = 0; index < 8; index++) {
                        int nextH = dir[index][0] + curH;
                        int nextW = dir[index][1] + curW;

                        if (nextH < 0 || nextW < 0 || MAXSIZE <= nextW || MAXSIZE <= nextH) {
                            continue;
                        }

                        if (map[nextH][nextW] == 1) {
                            map[nextH][nextW] = 0;
                            Q.push({nextH, nextW});
                        }
                    }
                }

                result++;
            }
        }

        cout << result << endl;
    }
    return 0;
}