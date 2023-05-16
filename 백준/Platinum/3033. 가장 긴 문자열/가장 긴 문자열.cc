#include <bits/stdc++.h>

int max(int a, int b) {
    if(a > b)
        return a;
    return b;
}

std::vector<int> getSuffixArray(const std::string &s) {
    int n = s.length();
    int t = 1;
    std::vector<int> g(2*n), tg(n), sa(n);

    for (int i = 0; i < n; i++) {
        sa[i] = i;
        g[i] = int(s[i]) - int('a');
        g[n + i] = -1;
    }

    while (t <= n) {
        auto cmp = [&g, &t](int i, int j) {
            if (g[i] != g[j]) {
                return g[i] < g[j];
            }
            return g[i + t] < g[j + t];
        };

        std::sort(sa.begin(), sa.end(), cmp);

        tg[sa[0]] = 0;
        for (int i = 1; i < n; i++) {
            if (cmp(sa[i - 1], sa[i])) {
                tg[sa[i]] = tg[sa[i - 1]] + 1;
            } else {
                tg[sa[i]] = tg[sa[i - 1]];
            }
        }

        g.swap(tg);
        t <<= 1;
    }
    return sa;
}

std::vector<int> getLCP(const std::string &s, const std::vector<int> &sa) {
    int n = s.length();
    std::vector<int> rank(n), lcp(n);

    for (int i = 0; i < n; i++) {
        rank[sa[i]] = i;
    }

    int h = 0;
    for (int i = 0; i < n; i++) {
        if (h > 0) {
            h--;
        }
        if (rank[i] == 0) {
            continue;
        }
        int j = sa[rank[i] - 1];
        while (j + h < n && i + h < n && s[j + h] == s[i + h]) {
            h++;
        }
        lcp[rank[i]] = h;
    }
    return lcp;
}

int main() {
    int l, answer = 0;
    std::string s;
    
    std::cin >> l >> s;

    std::vector<int> sa = getSuffixArray(s);
    std::vector<int> lcp = getLCP(s, sa);

    for (int v : lcp) {
        answer = max(answer, v);
    }

    std::cout << answer << std::endl;

    return 0;
}