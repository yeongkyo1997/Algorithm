import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
bright = list(map(int, input().split()))
dp = [[-1] * 201 for _ in range(201)]


def solve(st, ed):
    if st == ed:
        return 0

    ret = dp[st][ed]
    if ret != -1:
        return ret

    ret = 1e9 + 7

    for i in range(st, ed):
        temp = 0 if bright[st] == bright[i + 1] else 1
        ret = min(ret, solve(st, i) + solve(i + 1, ed) + temp)

    dp[st][ed] = ret
    return ret


print(solve(0, N - 1))