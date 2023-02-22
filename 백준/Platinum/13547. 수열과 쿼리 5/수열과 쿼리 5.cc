#include <iostream>
#include <stdio.h>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <math.h>
#include <queue>
#include <set>
#include <map>
#include <list>
#include <utility>
#include <climits>
#include <functional>

#define MAX 100005
#define INF 987654321
#define MOD 1000000

#pragma warning(disable : 4996)

using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int, int> pi;
typedef pair<float, float> pf;

struct st {
    int lo;
    int hi;
    int index;
} s[MAX];

int n, m, a, b, val = 0, clo = 0, chi = 0, tlo, thi, arr[MAX], cnt[MAX * 10], ans[MAX];

bool cmp(st s1, st s2) {
    int tmp1 = s1.lo / sqrt(n);
    int tmp2 = s2.lo / sqrt(n);
    return tmp1 == tmp2 ? s1.hi < s2.hi : tmp1 < tmp2;
}

void my_add(int in) {
    val += ++cnt[in] == 1 ? 1 : 0;
}

void my_sub(int in) {
    val -= --cnt[in] == 0 ? 1 : 0;
}

int main() {
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
        scanf("%d", &arr[i]);

    scanf("%d", &m);

    for (int i = 0; i < m; i++) {
        scanf("%d%d", &a, &b);

        s[i].lo = a, s[i].hi = b, s[i].index = i;
    }
    
    sort(s, s + m, cmp);

    for (int i = 0; i < m; i++) {
        tlo = s[i].lo, thi = s[i].hi;

        for (int k = clo; k < tlo; k++)
            my_sub(arr[k]);

        for (int k = chi + 1; k <= thi; k++)
            my_add(arr[k]);

        for (int k = tlo; k < clo; k++)
            my_add(arr[k]);

        for (int k = thi + 1; k <= chi; k++)
            my_sub(arr[k]);

        ans[s[i].index] = val;
        clo = tlo, chi = thi;
    }

    for (int i = 0; i < m; i++)
        printf("%d\n", ans[i]);
}
