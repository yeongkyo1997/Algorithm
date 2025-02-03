#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct State
{
    int len, link, occ;
    int next[26];
};

const int MAXN = 400001;
State st[MAXN];
int sz, last;

void sa_init()
{
    sz = 1;
    last = 0;
    st[0].len = 0;
    st[0].link = -1;
    st[0].occ = 0;
    for (int i = 0; i < 26; i++)
        st[0].next[i] = -1;
}

void sa_extend(char c)
{
    int cur = sz++;
    st[cur].len = st[last].len + 1;
    st[cur].occ = 1;
    for (int i = 0; i < 26; i++)
        st[cur].next[i] = -1;

    int letter = c - 'a';
    int p = last;

    while (p != -1 && st[p].next[letter] == -1)
    {
        st[p].next[letter] = cur;
        p = st[p].link;
    }

    if (p == -1)
    {
        st[cur].link = 0;
    }
    else
    {
        int q = st[p].next[letter];

        if (st[p].len + 1 == st[q].len)
        {
            st[cur].link = q;
        }
        else
        {

            int clone = sz++;
            st[clone].len = st[p].len + 1;
            for (int i = 0; i < 26; i++)
                st[clone].next[i] = st[q].next[i];
            st[clone].link = st[q].link;
            st[clone].occ = 0;

            while (p != -1 && st[p].next[letter] == q)
            {
                st[p].next[letter] = clone;
                p = st[p].link;
            }
            st[q].link = st[cur].link = clone;
        }
    }
    last = cur;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int L;
    cin >> L;
    string s;
    cin >> s;

    sa_init();
    for (int i = 0; i < s.size(); i++)
    {
        sa_extend(s[i]);
    }

    vector<int> order(sz);
    for (int i = 0; i < sz; i++)
    {
        order[i] = i;
    }
    sort(order.begin(), order.end(), [](int a, int b)
         { return st[a].len > st[b].len; });

    for (int i = 0; i < sz; i++)
    {
        int v = order[i];
        if (st[v].link != -1)
            st[st[v].link].occ += st[v].occ;
    }

    int answer = 0;
    for (int i = 1; i < sz; i++)
    {
        if (st[i].occ >= 2)
        {
            answer = max(answer, st[i].len);
        }
    }

    cout << answer << "\n";
    return 0;
}