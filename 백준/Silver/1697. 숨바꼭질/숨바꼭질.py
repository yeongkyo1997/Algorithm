import sys
from collections import deque


def input(): return sys.stdin.readline().strip()


N, K = map(int, input().split())


heap = [(0, N)]
q = deque([(0, N)])
visited = [False] * 100001

while heap:
    depth, cur = q.popleft()

    if cur == K:
        print(depth)
        break
    if 0 <= cur * 2 <= 100000 and not visited[cur * 2]:
        q.append((depth + 1, cur * 2))
        visited[cur * 2] = True
    if 0 <= cur + 1 <= 100000 and not visited[cur + 1]:
        q.append((depth + 1, cur + 1))
        visited[cur + 1] = True
    if 0 <= cur - 1 <= 100000 and not visited[cur - 1]:
        q.append((depth + 1, cur - 1))
        visited[cur - 1] = True