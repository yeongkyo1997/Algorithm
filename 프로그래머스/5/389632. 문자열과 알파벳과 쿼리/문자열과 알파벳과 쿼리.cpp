#include <bits/stdc++.h>
using namespace std;

class SegmentTree
{
public:
    int n;
    vector<int> tree;
    vector<int> lazy;
    vector<int> updates;
    unordered_map<int, int> mp;
    vector<int> root;

    SegmentTree(int n) : n(n)
    {
        tree.assign(4 * n, 0);
        lazy.assign(4 * n, 0);
        updates.push_back(0);
        mp[0] = 0;
        root.resize(200000);
        for (int i = 0; i < 200000; i++)
        {
            root[i] = i;
        }
    }

    int _find(int x)
    {
        if (root[x] == x)
            return x;
        return root[x] = _find(root[x]);
    }

    void mergeRep(int x, int y)
    {
        if (mp.find(y) == mp.end())
            return;
        int yIndex = _find(mp[y]);
        if (mp.find(x) == mp.end())
        {
            updates.push_back(x);
            mp[x] = updates.size() - 1;
        }
        int xIndex = _find(mp[x]);
        root[yIndex] = xIndex;
    }

    void moveRep(int x, int new_id)
    {
        if (mp.find(x) == mp.end())
            return;
        int updateIndex = _find(mp[x]);
        int oldVal = updates[updateIndex];
        updates[updateIndex] = new_id;
        mp.erase(oldVal);
        mp[new_id] = updateIndex;
    }

    void push(int node, int start, int end)
    {
        if (lazy[node] != 0)
        {
            tree[node] = lazy[node];
            if (start != end)
            {
                lazy[node * 2 + 1] = lazy[node];
                lazy[node * 2 + 2] = lazy[node];
            }
            lazy[node] = 0;
        }
    }

    void _updateRange(int node, int start, int end, int l, int r, int v)
    {
        push(node, start, end);
        if (end < l || start > r)
            return;
        if (l <= start && end <= r)
        {
            tree[node] = v;
            if (start != end)
            {
                lazy[node * 2 + 1] = v;
                lazy[node * 2 + 2] = v;
            }
            return;
        }
        int mid = (start + end) / 2;
        _updateRange(node * 2 + 1, start, mid, l, r, v);
        _updateRange(node * 2 + 2, mid + 1, end, l, r, v);
        tree[node] = max(tree[node * 2 + 1], tree[node * 2 + 2]);
    }

    void updateRange(int l, int r, int new_id)
    {
        updates.push_back(new_id);
        int new_index = updates.size() - 1;
        mp[new_id] = new_index;
        _updateRange(0, 0, n - 1, l, r, new_index);
    }

    int _query(int node, int start, int end, int idx)
    {
        push(node, start, end);
        if (start == end)
            return tree[node];
        int mid = (start + end) / 2;
        if (idx <= mid)
            return _query(node * 2 + 1, start, mid, idx);
        else
            return _query(node * 2 + 2, mid + 1, end, idx);
    }

    int indexQuery(int x)
    {
        return _query(0, 0, n - 1, x);
    }

    int query(int x)
    {
        return updates[_find(indexQuery(x))];
    }
};

vector<int> convertWord(const string &word)
{
    vector<int> res;
    for (char c : word)
    {
        res.push_back(c - 'a');
    }
    return res;
}

const int ALPHA_LEN = 26;

vector<string> solution(string s, vector<string> queries)
{

    vector<int> sVec;
    for (char c : s)
    {
        sVec.push_back(c - 'a');
    }
    int n = sVec.size();

    vector<SegmentTree> sts;
    for (int i = 0; i < ALPHA_LEN; i++)
    {
        sts.push_back(SegmentTree(n));
    }

    vector<string> res;
    int groupId = 0;

    for (auto &query : queries)
    {
        istringstream iss(query);
        vector<string> tokens;
        string token;
        while (iss >> token)
        {
            tokens.push_back(token);
        }
        if (tokens.empty())
            continue;

        string fl = tokens[0];
        if (fl == "1")
        {
            int x = stoi(tokens[1]) - 1;
            int y = stoi(tokens[2]) - 1;
            int xid = sts[sVec[x]].query(x);
            int yid = sts[sVec[y]].query(y);
            res.push_back(xid == yid ? "YES" : "NO");
        }
        else if (fl == "2")
        {
            groupId++;
            int x = stoi(tokens[1]) - 1;
            vector<int> wordNum = convertWord(tokens[2]);
            unordered_set<int> wordSet(wordNum.begin(), wordNum.end());
            int id_val = sts[sVec[x]].query(x);
            for (int c : wordSet)
            {
                sts[c].moveRep(id_val, groupId);
            }
        }
        else if (fl == "3")
        {
            groupId++;
            int x = stoi(tokens[1]) - 1;
            int y = stoi(tokens[2]) - 1;
            vector<int> wordNum = convertWord(tokens[3]);
            unordered_set<int> wordSet(wordNum.begin(), wordNum.end());
            for (int c : wordSet)
            {
                sts[c].updateRange(x, y, groupId);
            }
        }
        else if (fl == "4")
        {
            int x = stoi(tokens[1]) - 1;
            int y = stoi(tokens[2]) - 1;
            int xid = sts[sVec[x]].query(x);
            int yid = sts[sVec[y]].query(y);
            if (xid > yid)
                swap(xid, yid);
            for (int i = 0; i < ALPHA_LEN; i++)
            {
                sts[i].mergeRep(xid, yid);
            }
        }
        else if (fl == "5")
        {
            vector<string> bucket;

            vector<vector<int>> collectBox(groupId + 1, vector<int>(ALPHA_LEN, 0));
            for (int x = 0; x < n; x++)
            {
                int id_val = sts[sVec[x]].query(x);

                if (id_val < (int)collectBox.size())
                    collectBox[id_val][sVec[x]]++;
            }
            for (int i = 0; i < (int)collectBox.size(); i++)
            {
                string box = "";
                for (int j = 0; j < ALPHA_LEN; j++)
                {
                    if (collectBox[i][j] == 0)
                        continue;
                    if (!box.empty())
                        box += " ";
                    box += string(1, char('a' + j)) + " " + to_string(collectBox[i][j]);
                }
                if (!box.empty())
                    bucket.push_back(box);
            }
            for (auto &str : bucket)
                res.push_back(str);
        }
    }

    return res;
}