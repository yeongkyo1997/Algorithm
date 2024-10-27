#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int dx[4] = {0, -1, 0, 1};
const int dy[4] = {-1, 0, 1, 0};
const int bits[4] = {1, 2, 4, 8};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> board(M, vector<int>(N));
    for (int x = 0; x < M; ++x)
    {
        for (int y = 0; y < N; ++y)
        {
            cin >> board[x][y];
        }
    }

    // 방문 여부 및 방 번호 저장
    vector<vector<int>> visited(M, vector<int>(N, 0));
    int room_id = 1;
    vector<int> room_sizes;

    // BFS를 위한 큐
    queue<pair<int, int>> q;

    // 방 탐색: 방의 개수와 각 방의 크기 계산
    for (int x = 0; x < M; ++x)
    {
        for (int y = 0; y < N; ++y)
        {
            if (visited[x][y] == 0)
            {
                // 새로운 방 탐색 시작
                q.push({x, y});
                visited[x][y] = room_id;
                int size = 1;

                while (!q.empty())
                {
                    pair<int, int> cur = q.front();
                    q.pop();
                    int xx = cur.first;
                    int yy = cur.second;
                    int walls = board[xx][yy];

                    for (int i = 0; i < 4; ++i)
                    {
                        // 해당 방향에 벽이 없는지 확인
                        if ((walls & bits[i]) == 0)
                        {
                            int nx = xx + dx[i];
                            int ny = yy + dy[i];
                            // 유효한 좌표인지 확인
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N && visited[nx][ny] == 0)
                            {
                                visited[nx][ny] = room_id;
                                q.push({nx, ny});
                                size++;
                            }
                        }
                    }
                }
                room_sizes.push_back(size);
                room_id++;
            }
        }
    }

    int num_rooms = room_id - 1;
    int max_room = *max_element(room_sizes.begin(), room_sizes.end());

    // 하나의 벽을 제거하여 얻을 수 있는 가장 큰 방의 크기 계산
    int max_combined = 0;
    for (int x = 0; x < M; ++x)
    {
        for (int y = 0; y < N; ++y)
        {
            int cur_room = visited[x][y];
            int walls = board[x][y];
            for (int i = 0; i < 4; ++i)
            {
                if (walls & bits[i])
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < M && ny >= 0 && ny < N)
                    {
                        int adj_room = visited[nx][ny];
                        if (cur_room != adj_room)
                        {
                            int comb_size = room_sizes[cur_room - 1] + room_sizes[adj_room - 1];
                            if (comb_size > max_combined)
                            {
                                max_combined = comb_size;
                            }
                        }
                    }
                }
            }
        }
    }

    cout << num_rooms << "\n";
    cout << max_room << "\n";
    cout << max_combined;

    return 0;
}