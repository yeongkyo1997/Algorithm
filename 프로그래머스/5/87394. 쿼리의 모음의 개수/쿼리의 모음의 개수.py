from collections import defaultdict

MOD = 998244353
N = 55
M = 100005
a = [0] * N
vis = [0] * M
to = [0] * M
ttl = [0] * M
ncr = [[0] * N for _ in range(N)]
tmp = [[[0] * N for _ in range(N)] for _ in range(N)]
dp = [[0] * N for _ in range(N)]
pw = [[0] * N for _ in range(N)]
res = [0] * N
tmp2 = [0] * N
b = [0] * N
p = [0] * N
px = [0] * N

def mypow(x, b):
    if b == 0:
        return 1
    t = mypow(x, b // 2)
    return ((t * t % MOD) * x % MOD) if (b % 2) else (t * t % MOD)

def Do2(x, m):
    cnt = 0
    for i in range(1, m + 1):
        if b[i]:
            cnt += 1
            p[cnt] = i
            px[i] = cnt
    for i in range(m + 1):
        for j in range(q + 1):
            for k in range(cnt + 1):
                tmp[i][j][k] = 0
    for i in range(q + 1):
        tmp[0][i][0] = dp[to[x]][i]
    for i in range(m):
        for j in range(q + 1):
            for k in range(cnt + 1):
                if k == 0 or p[k] <= i:
                    if k == 0 and b[i + 1]:
                        tmp[i + 1][j][px[i + 1]] = (tmp[i + 1][j][px[i + 1]] + tmp[i][j][k]) % MOD
                    else:
                        tmp[i + 1][j][k] = (tmp[i + 1][j][k] + tmp[i][j][k]) % MOD
                    if k == 0:
                        for t in range(1, q - j + 1):
                            tmp[i + 1][j + t][k] = (tmp[i + 1][j + t][k] + tmp[i][j][k] * pw[i + 1][t] % MOD * ncr[j + t][t]) % MOD
                        continue
                    for t in range(1, q - j + 1):
                        tmp[i + 1][j + t][k] = (tmp[i + 1][j + t][k] + tmp[i][j][k] * pw[i - p[k] + 1][t] % MOD * ncr[j + t][t]) % MOD
                        tmp[i + 1][j + t][0] = (tmp[i + 1][j + t][0] + tmp[i][j][k] * (pw[i + 1][t] + MOD - pw[i - p[k] + 1][t]) % MOD * ncr[j + t][t]) % MOD
    for i in range(q + 1):
        dp[to[x]][i] = tmp[m][i][0]

def Do(x):
    dp[to[x]][0] = 1
    l = 1
    while l <= n:
        if x <= a[l]:
            r = l
            while r + 1 <= n and x <= a[r + 1]:
                r += 1
            for i in range(l, r + 1):
                b[i - l + 1] = (x == a[i])
            Do2(x, r - l + 1)
            l = r
        l += 1

def solution(qq, arr):
    global q, n, ncr, pw, a, vis, to, res, ttl, tmp2, MOD
    n = len(arr)
    q = qq
    a = [0] + arr
    for i in range(1, n + 1):
        vis[a[i]] = 1
    ncr[0][0] = 1
    for i in range(1, 51):
        ncr[i][0] = ncr[i][i] = 1
        for j in range(1, i):
            ncr[i][j] = (ncr[i - 1][j - 1] + ncr[i - 1][j]) % MOD
    for i in range(51):
        pw[i][0] = 1
        for j in range(1, 51):
            pw[i][j] = pw[i][j - 1] * i % MOD
    m = 1
    for i in range(1, M):
        if vis[i]:
            to[i] = m
            m += 1
    res[0] = 1
    for i in range(M - 1, 0, -1):
        if vis[i]:
            Do(i)
            for j in range(q + 1):
                tmp2[j] = 0
            for j in range(q + 1):
                for k in range(q - j + 1):
                    tmp2[j + k] = (tmp2[j + k] + res[j] * dp[to[i]][k] % MOD * ncr[j + k][k]) % MOD
            for j in range(q + 1):
                res[j] = tmp2[j]
    for l in range(1, n + 1):
        mn = 1e9
        for r in range(l, n + 1):
            mn = min(mn, a[r])
            ttl[1] += 1
            ttl[mn] -= 1
    nuse = 0
    for i in range(1, M):
        ttl[i] += ttl[i - 1]
        if not vis[i]:
            nuse = (nuse + ttl[i]) % MOD
    for j in range(q + 1):
        tmp2[j] = 0
    for j in range(q + 1):
        for k in range(q - j + 1):
            tmp2[j + k] = (tmp2[j + k] + res[j] * mypow(nuse, k) % MOD * ncr[j + k][k]) % MOD
    for j in range(q + 1):
        res[j] = tmp2[j]
    return res[q]
