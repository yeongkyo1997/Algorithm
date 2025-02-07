#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct State
{
    int len, link;
    int next[26];
    int occ;
    State() : len(0), link(-1), occ(0)
    {
        for (int i = 0; i < 26; i++)
            next[i] = -1;
    }
};

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int L;
    cin >> L;
    string s;
    cin >> s;
    int n = s.size();

    vector<State> st;
    st.reserve(2 * n);
    st.push_back(State());
    int last = 0;

    for (char c : s)
    {
        int cur = st.size();
        st.push_back(State());
        st[cur].len = st[last].len + 1;
        st[cur].occ = 1;
        int letter = c - 'a';
        int p = last;
        for (; p != -1 && st[p].next[letter] == -1; p = st[p].link)
            st[p].next[letter] = cur;
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
                int clone = st.size();
                st.push_back(State());
                st[clone].len = st[p].len + 1;
                st[clone].link = st[q].link;

                for (int j = 0; j < 26; j++)
                {
                    st[clone].next[j] = st[q].next[j];
                }
                st[clone].occ = 0;
                for (; p != -1 && st[p].next[letter] == q; p = st[p].link)
                    st[p].next[letter] = clone;
                st[q].link = st[cur].link = clone;
            }
        }
        last = cur;
    }

    vector<int> order(st.size());
    for (int i = 0; i < st.size(); i++)
        order[i] = i;
    sort(order.begin(), order.end(), [&st](int a, int b)
         { return st[a].len > st[b].len; });

    for (int idx : order)
    {
        if (st[idx].link != -1)
            st[st[idx].link].occ += st[idx].occ;
    }

    int ans = 0;
    for (int i = 0; i < st.size(); i++)
    {
        if (st[i].occ >= 2 && st[i].len > ans)
            ans = st[i].len;
    }

    cout << ans << "\n";
    return 0;
}