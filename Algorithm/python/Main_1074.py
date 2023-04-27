import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, r, c = map(int, input().split())


def solve(n, x, y):
    if n == 0:
        return 0
    half = 2 ** (n - 1)
    if x < half and y < half:
        return solve(n - 1, x, y)
    elif x < half <= y:
        return half ** 2 + solve(n - 1, x, y - half)
    elif x >= half > y:
        return 2 * half ** 2 + solve(n - 1, x - half, y)
    else:
        return 3 * half ** 2 + solve(n - 1, x - half, y - half)


print(solve(N, r, c))
