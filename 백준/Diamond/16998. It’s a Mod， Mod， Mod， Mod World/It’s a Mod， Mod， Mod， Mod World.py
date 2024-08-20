import math
import sys

input = lambda: sys.stdin.readline().rstrip()
print = sys.stdout.write


def div_sum(p, q, n):
    if n == 0 or p == 0:
        return 0
    if q == 1:
        return p * n * (n + 1) // 2
    if p > q:
        return div_sum(p % q, q, n) + n * (n + 1) // 2 * (p // q)
    return n * (n * p // q) + (n // q) - div_sum(q, p, n * p // q)


def mod_sum(p, q, n):
    gcd = math.gcd(p, q)
    return p * n * (n + 1) // 2 - q * div_sum(p // gcd, q // gcd, n)


def solve():
    t = int(input())

    for _ in range(t):
        p, q, n = map(int, input().split())
        print(f'{mod_sum(p, q, n)}\n')


if __name__ == "__main__":
    solve()