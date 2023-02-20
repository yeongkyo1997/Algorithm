#include <iostream>
#include <cstdio>
#include <queue>
 
using namespace std;
 
const int MAX_NODE = 63;
 
int convert(char ch)
{
    if ('a' <= ch && ch <= 'z')
        return (ch - 'a');
    else if ('A' <= ch && ch <= 'Z')
        return (37 + ch - 'A');
 
    else if (ch == '.')
        return 26;
 
    else if ('0' <= ch && ch <= '9')
        return (ch - '0' + 27);
}
 
char recover(int n)
{
    if (0 <= n && n <= 25)
        return ('a' + n);
    else if (n == 26)
        return '.';
    else if (27 <= n && n <= 36)
        return (n - 27 + '0');
    else if (37 <= n && n <= 63 - 1)
        return (n - 37 + 'A');
}
 
 
struct Trie {
    Trie *next[MAX_NODE];
    bool isEnd, isForbidden, hasChild;
    Trie() {
        for (int i = 0; i < MAX_NODE; i++)
        {
            next[i] = nullptr;
            isEnd = isForbidden = false;
        }
    }
 
    ~Trie() {
        for (int i = 0; i < MAX_NODE; i++)
            if (next[i])
                delete next[i];
    }
};
 
Trie *root;
 
int main()
{
    int tc;
    scanf("%d", &tc);
 
    while (tc--)
    {
        root = new Trie;
 
        int n;
        scanf("%d", &n);
 
        for (int i = 0; i < n; i++)
        {
            char str[25];
            scanf("%s", str);
 
            Trie *pos = root;
            for (int j = 0; str[j]; j++)
            {
                int nowCh = convert(str[j]);
 
                if (!pos->next[nowCh])
                    pos->next[nowCh] = new Trie;
 
                pos = pos->next[nowCh];
            }
 
            pos->isEnd = true;
        }
 
        int m;
        scanf("%d", &m);
 
        if (!m)
        {
            printf("1\n");
            continue;
        }
        for (int i = 0; i < m; i++)
        {
            char str[25];
            scanf("%s", str);
 
            Trie *pos = root;
 
            for (int j = 0; str[j]; j++)
            {
                int nowCh = convert(str[j]);
 
                if (pos->next[nowCh])
                    pos->next[nowCh]->isForbidden = true;
                else
                    break;
 
                pos = pos->next[nowCh];
            }
        }
 
        int ans = 0;
        queue<Trie *> q;
 
        q.push(root);
 
        while (!q.empty())
        {
            Trie *cur = q.front();
 
            q.pop();
            for (int i = 0; i < MAX_NODE; i++)
            {
                if (cur->next[i])
                {
                    if (cur->next[i]->isForbidden)
                    {
                        if (cur->next[i]->isEnd)
                            ans++;
 
                        q.push(cur->next[i]);
                    }
                    else
                        ans++;
                }
            }
        }
 
        printf("%d\n", ans);
    }
 
    return 0;
}