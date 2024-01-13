import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())


q = deque(list(range(1, N + 1)))

result = []
while q:
    q.rotate(-K)
    result.append(q.pop())
print('<', end='')
print(*result, sep=', ', end='')
print('>')