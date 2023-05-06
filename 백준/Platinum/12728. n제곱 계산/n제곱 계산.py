import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

MOD = 1000


def mul(a, b):
    n = len(a)
    m = len(b)
    l = len(b[0])
    res = [[0] * l for _ in range(n)]
    for i in range(n):
        for j in range(l):
            for k in range(m):
                res[i][j] += a[i][k] * b[k][j]
            res[i][j] %= MOD
    return res


def power(a, n):
    res = [[0] * len(a) for _ in range(len(a))]
    for i in range(len(a)):
        res[i][i] = 1
    while n > 0:
        if n % 2 == 1:
            res = mul(res, a)
        n //= 2
        a = mul(a, a)
    return res


def solve():
    n = int(input())
    a = [[6, -4], [1, 0]]
    res = power(a, n - 1)
    ret = str(((28 * res[1][0] + 6 * res[1][1]) - 1) % MOD)
    while len(ret) < 3:
        ret = "0" + ret
    return ret


for i in range(int(input())):
    print("Case #%d: %s" % (i + 1, solve()))