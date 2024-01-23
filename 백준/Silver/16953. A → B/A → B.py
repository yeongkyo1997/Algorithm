import sys
from collections import deque

sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


A, B = map(int, input().split())

q = deque([(A, 1)])

while q:
    cur, depth = q.popleft()
    if cur == B:
        print(depth)
        break

    if cur * 2 > B:
        continue
    q.append((cur * 2, depth + 1))
    if cur * 10 + 1 > B:
        continue
    q.append((cur * 10 + 1, depth + 1))
else:
    print(-1)