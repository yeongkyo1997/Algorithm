import collections

MOD = 1000000007
comb = [[0] * 1010 for _ in range(1010)]

for i in range(1010):
    comb[i][0] = comb[i][i] = 1
    for j in range(1, i):
        comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD

for t in range(1, int(input()) + 1):
    s = input()
    n = len(s) - 1
    c = s[1:].count(s[0])

    e = collections.defaultdict(int)
    for i in range(n):
        x = i * (n - i)
        r = (i == c) * n * (n + 1) % MOD
        z = (i + 2) * (n - i)
        e[i + 1] = (x * e[i] + r) % MOD * pow(z, MOD - 2, MOD) % MOD

    result = 0
    sum_ = (n == c)
    for i in range(n, -1, -1):
        result = (result + sum_ * comb[n][i]) % MOD
        sum_ = (sum_ + e[i]) % MOD

    result = result * pow(comb[n][c], MOD - 2, MOD) % MOD
    result = result * pow(pow(2, n + 1), MOD - 2, MOD) % MOD

    print(f'#{t} {result}')
