import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def solve(n):
    if n == 1:
        return a % c

    k = solve(n // 2) % c

    if n % 2 == 0:
        return k * k % c
    else:
        return k * k % c * a % c


a, b, c = map(int, input().split())

print(solve(b))
