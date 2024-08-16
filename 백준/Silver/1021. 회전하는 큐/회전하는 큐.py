import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()


def solve(N, pos):
    q = deque(range(1, N + 1))
    ret = 0

    for p in pos:
        cur = q.index(p)

        left = cur
        right = len(q) - cur

        ret += min(left, right)

        q.rotate(-cur)
        q.popleft()

    return ret


N, M = map(int, input().split())
pos = list(map(int, input().split()))

result = solve(N, pos)
print(result)