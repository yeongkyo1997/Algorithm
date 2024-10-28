#include <bits/stdc++.h>
using namespace std;

int getIndex(int r, int c)
{
    return (r - 1) * 50 + (c - 1);
}

struct DSU
{
    vector<int> parent;
    vector<vector<int>> group_members;
    vector<string> value;

    DSU() : parent(2500), group_members(2500, vector<int>()), value(2500, "")
    {
        for (int i = 0; i < 2500; ++i)
        {
            parent[i] = i;
            group_members[i].push_back(i);
        }
    }

    int Find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = Find(parent[x]);
        }
        return parent[x];
    }

    void UnionCells(int x, int y)
    {
        int root_x = Find(x);
        int root_y = Find(y);
        if (root_x == root_y)
            return;

        parent[root_y] = root_x;
        for (auto &cell : group_members[root_y])
        {
            group_members[root_x].push_back(cell);
        }
        group_members[root_y].clear();

        if (value[root_x].empty() && !value[root_y].empty())
        {
            value[root_x] = value[root_y];
        }
    }

    void Unmerge(int x)
    {
        int root = Find(x);
        string group_val = value[root];
        vector<int> members = group_members[root];
        for (auto &cell : members)
        {
            parent[cell] = cell;
            group_members[cell].clear();
            group_members[cell].push_back(cell);
            value[cell] = "";
        }
        value[x] = group_val;
    }
};

vector<string> solution(vector<string> commands)
{
    DSU dsu;
    vector<string> answer;

    for (auto &cmd : commands)
    {
        vector<string> tokens;
        string token;
        stringstream ss(cmd);
        while (ss >> token)
        {
            tokens.push_back(token);
        }

        if (tokens[0] == "UPDATE")
        {
            if (tokens.size() == 4)
            {
                int r = stoi(tokens[1]);
                int c = stoi(tokens[2]);
                string val = tokens[3];
                int idx = getIndex(r, c);
                int root = dsu.Find(idx);
                dsu.value[root] = val;
            }
            else if (tokens.size() == 3)
            {
                string val1 = tokens[1];
                string val2 = tokens[2];
                for (int i = 0; i < 2500; ++i)
                {
                    if (dsu.parent[i] == i && dsu.value[i] == val1)
                    {
                        dsu.value[i] = val2;
                    }
                }
            }
        }
        else if (tokens[0] == "MERGE")
        {
            // "MERGE r1 c1 r2 c2"
            int r1 = stoi(tokens[1]);
            int c1 = stoi(tokens[2]);
            int r2 = stoi(tokens[3]);
            int c2 = stoi(tokens[4]);
            int idx1 = getIndex(r1, c1);
            int idx2 = getIndex(r2, c2);
            dsu.UnionCells(idx1, idx2);
        }
        else if (tokens[0] == "UNMERGE")
        {
            int r = stoi(tokens[1]);
            int c = stoi(tokens[2]);
            int idx = getIndex(r, c);
            dsu.Unmerge(idx);
        }
        else if (tokens[0] == "PRINT")
        {
            int r = stoi(tokens[1]);
            int c = stoi(tokens[2]);
            int idx = getIndex(r, c);
            int root = dsu.Find(idx);
            if (dsu.value[root].empty())
            {
                answer.push_back("EMPTY");
            }
            else
            {
                answer.push_back(dsu.value[root]);
            }
        }
    }

    return answer;
}