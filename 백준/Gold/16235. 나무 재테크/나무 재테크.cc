#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int dir[8][2] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
int N, M, K;

vector<vector<int>> board;
vector<vector<int>> add_board;
vector<vector<vector<int>>> trees;

void spring()
{
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (!trees[i][j].empty())
            {
                sort(trees[i][j].begin(), trees[i][j].end());

                vector<int> del_list;
                for (int t = 0; t < trees[i][j].size(); ++t)
                {
                    if (board[i][j] >= trees[i][j][t])
                    {
                        board[i][j] -= trees[i][j][t];
                        trees[i][j][t] += 1;
                    }
                    else
                    {
                        del_list.push_back(t);
                    }
                }
                for (int d = del_list.size() - 1; d >= 0; --d)
                {
                    board[i][j] += trees[i][j][del_list[d]] / 2;
                    trees[i][j].erase(trees[i][j].begin() + del_list[d]);
                }
            }
        }
    }
}

void fall()
{
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (!trees[i][j].empty())
            {
                for (int t : trees[i][j])
                {
                    if (t % 5 == 0)
                    {
                        for (int d = 0; d < 8; ++d)
                        {
                            int nx = i + dir[d][0];
                            int ny = j + dir[d][1];

                            if (0 <= nx && nx < N && 0 <= ny && ny < N)
                            {
                                trees[nx][ny].push_back(1);
                            }
                        }
                    }
                }
            }
        }
    }
}

void winter()
{
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            board[i][j] += add_board[i][j];
        }
    }
}

int main()
{
    cin >> N >> M >> K;

    board.assign(N, vector<int>(N, 5));
    add_board.assign(N, vector<int>(N));
    trees.assign(N, vector<vector<int>>(N));

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> add_board[i][j];
        }
    }

    for (int i = 0; i < M; ++i)
    {
        int x, y, year;
        cin >> x >> y >> year;
        trees[x - 1][y - 1].push_back(year);
    }

    for (int i = 0; i < K; ++i)
    {
        spring();
        fall();
        winter();
    }

    int result = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            result += trees[i][j].size();
        }
    }

    cout << result << endl;

    return 0;
}