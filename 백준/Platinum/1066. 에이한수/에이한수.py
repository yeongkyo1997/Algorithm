import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, A = map(int, input().split())
MOD = 10 ** 9 + 7
arr = [[[[-1 for _ in range(11)] for _ in range(11)] for _ in range(11)] for _ in range(1010)]


def solve(x, la, dist, a):
    if x == N:
        return a == 0

    if arr[x][la][dist][a] != -1:
        return arr[x][la][dist][a]

    arr[x][la][dist][a] = 0

    if dist != 10:
        for i in range(la, 10):
            if i == la + dist:
                arr[x][la][dist][a] += solve(x + 1, la + dist, dist, a)
                arr[x][la][dist][a] %= MOD
            elif a:
                arr[x][la][dist][a] += solve(x + 1, i, 10, a - 1)
                arr[x][la][dist][a] %= MOD
    else:
        for i in range(la, 10):
            arr[x][la][dist][a] += solve(x + 1, i, i - la, a)
            arr[x][la][dist][a] %= MOD
    return arr[x][la][dist][a]


if 9 < A:
    print(0)
    exit(0)
result = 0
for i in range(1, 10):
    result += solve(1, i, 10, A - 1)
    result %= MOD
print(result)