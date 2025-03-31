import java.util.*;

public
class Solution
{

    static int root(int[] rt, int x)
    {
        while (x != rt[x])
        {
            rt[x] = rt[rt[x]];
            x = rt[x];
        }
        return x;
    }

    static void unite(int[] rt, int[] sz, int a, int b)
    {
        a = root(rt, a);
        b = root(rt, b);
        if (a == b)
            return;
        if (sz[a] > sz[b])
        {
            int temp = a;
            a = b;
            b = temp;
        }
        rt[a] = b;
        sz[b] += sz[a];
    }

public
    static List<String> solution(int n, int[][] queries)
    {
        List<String> ans = new ArrayList<>();

        int[] rt = new int[n];
        int[] sz = new int[n];
        int[] li = new int[n];
        int[] tm = new int[n];
        int[] nxt = new int[n];
        int[] prv = new int[n];

        ArrayList<Integer> hd = new ArrayList<>();
        ArrayList<Integer> tl = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            rt[i] = i;
            li[i] = i;
            sz[i] = 1;
            nxt[i] = -1;
            prv[i] = -1;
            tm[i] = 0;
            hd.add(i);
            tl.add(i);
        }

        int ix = n;
        int curr = 1;

        for (int[] q : queries)
        {
            int qi = q[0];
            int x = root(rt, q[1]);
            int y = root(rt, q[2]);

            if (qi == 1)
            {
                if (li[x] == li[y])
                    continue;
                int i = hd.get(li[y]);
                while (i != -1)
                {
                    unite(rt, sz, i, y);
                    i = nxt[i];
                }

                hd.set(li[y], -1);
                tl.set(li[y], -1);
                y = root(rt, y);
                li[y] = li[x];
                int j = tl.get(li[x]);
                nxt[j] = y;
                prv[y] = j;
                nxt[y] = -1;
                tl.set(li[x], y);
                tm[y] = curr;
            }

            if (qi == 2)
            {
                if (tm[x] > tm[y])
                    continue;
                int i = x;
                while (true)
                {
                    unite(rt, sz, i, x);
                    if (i == y)
                        break;
                    i = nxt[i];
                }

                if (hd.get(li[x]) == x && tl.get(li[x]) == y)
                {
                    hd.set(li[x], -1);
                    tl.set(li[x], -1);
                }
                else if (hd.get(li[x]) == x && tl.get(li[x]) != y)
                {
                    hd.set(li[x], nxt[y]);
                    if (nxt[y] != -1)
                        prv[nxt[y]] = -1;
                }
                else if (hd.get(li[x]) != x && tl.get(li[x]) == y)
                {
                    tl.set(li[x], prv[x]);
                    if (prv[x] != -1)
                        nxt[prv[x]] = -1;
                }
                else
                {
                    nxt[prv[x]] = nxt[y];
                    if (nxt[y] != -1)
                        prv[nxt[y]] = prv[x];
                }
                x = root(rt, x);
                prv[x] = -1;
                nxt[x] = -1;
                hd.add(x);
                tl.add(x);
                li[x] = ix++;
                tm[x] = curr;
            }

            if (qi == 3)
            {
                ans.add(li[x] == li[y] ? "Yes" : "No");
            }

            curr++;
        }
        return ans;
    }
}