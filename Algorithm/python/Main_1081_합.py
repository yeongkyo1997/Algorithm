import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

arr, b = map(int, input().split())


def solve(n):
    if n <= 0:
        return 0
    c = [0] * 10
    s = 1
    sum = 0
    while n > 0:
        t = n // (s * 10)
        r = n % (s * 10)
        for i in range(10):
            c[i] += t * s
        for i in range(1, r // s + 1):
            c[i] += s
        c[(r // s + 1) % 10] += r % s
        n -= 9 * s
        s *= 10
    for i in range(1, 10):
        sum += i * c[i]
    return sum


print(solve(b) - solve(arr - 1))
