import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N = int(input())

q = deque(list(range(1, N + 1)))

while len(q) != 1:
    q.popleft()
    q.rotate(-1)

print(q.pop())