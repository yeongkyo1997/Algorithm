import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())

result = []
q = deque(list(range(1, N + 1)))

while q:
    q.rotate(-(K - 1))
    result.append(q.popleft())

print('<', end='')
print(*result, sep=', ', end='')
print('>')