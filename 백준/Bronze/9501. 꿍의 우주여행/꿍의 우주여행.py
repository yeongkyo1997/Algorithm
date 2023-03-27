import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, d = map(int, input().split())
    result = 0

    for j in range(n):
        v, f, c = map(int, input().split())
        if f / c * v >= d:
            result += 1

    print(result)