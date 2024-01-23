import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

for a, b in arr:
    cnt = 0
    for c, d in arr:
        if a < c and b < d:
            cnt += 1
    print(cnt + 1, end=' ')