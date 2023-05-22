#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N, M;
vector<vector<int>> room;
vector<vector<bool>> nodes;
int visitCount;
vector<int> visit;
vector<int> matched;

int bipartite();
int dfs(int num);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int scopes[][2] = {{-1, 1}, {-1, 0}, {-1, -1}, {1, 1}, {1, 0}, {1, -1}};

    int C;
    cin >> C;

    while (C--)
    {
        cin >> N >> M;

        vector<vector<bool>> canSit(N, vector<bool>(M));

        int numbering = 1;
        int broken = 0;

        room = vector<vector<int>>(N, vector<int>(M));
        nodes = vector<vector<bool>>(N * M, vector<bool>(N * M));

        visitCount = 1;

        for (int n = 0; n < N; n++)
        {
            string temp;
            cin >> temp;

            for (int m = 0; m < M; m++)
            {
                room[n][m] = numbering++;

                if (temp[m] == '.')
                {
                    canSit[n][m] = true;
                }
                else
                {
                    canSit[n][m] = false;
                    broken++;
                }
            }
        }

        for (int n = 0; n < N; n++)
        {
            for (int m = 0; m < M; m += 2)
            {
                if (canSit[n][m])
                {
                    for (int i = 0; i < 6; i++)
                    {
                        int mo = m + scopes[i][0];
                        int no = n + scopes[i][1];

                        if (no > -1 && mo > -1 && no < N && mo < M && canSit[no][mo])
                        {
                            nodes[room[n][m] - 1][room[no][mo] - 1] = true;
                        }
                    }
                }
            }
        }

        int result = bipartite();

        cout << N * M - broken - result << "\n";
    }

    return 0;
}

int bipartite()
{
    int size = 0;

    visit = vector<int>(N * M);
    matched = vector<int>(N * M);

    fill(matched.begin(), matched.end(), -1);

    for (int n = 0; n < N; n++)
    {
        for (int m = 0; m < M; m += 2)
        {
            visitCount++;

            size += dfs(room[n][m] - 1);
        }
    }

    return size;
}

int dfs(int num)
{
    if (visit[num] != visitCount)
    {
        visit[num] = visitCount;

        for (int i = 0; i < N * M; i++)
        {
            if (nodes[num][i])
            {
                if (matched[i] == -1 || dfs(matched[i]) == 1)
                {
                    matched[i] = num;

                    return 1;
                }
            }
        }
    }

    return 0;
}