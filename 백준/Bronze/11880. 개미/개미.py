import sys


def solve():
    a, b, c = map(int, sys.stdin.readline().split())

    dist_sq1 = a * a + (b + c) * (b + c)

    dist_sq2 = b * b + (a + c) * (a + c)

    dist_sq3 = c * c + (a + b) * (a + b)

    min_dist_sq = min(dist_sq1, dist_sq2, dist_sq3)

    print(min_dist_sq)


t = int(sys.stdin.readline())


for _ in range(t):
    solve()
