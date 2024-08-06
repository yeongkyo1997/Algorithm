import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())

visited = set()

q = collections.deque()
q.append((N, 0))

while q:
    n, depth = q.popleft()
    if n == K:
        print(depth)
        break
    if 0 <= n + 1 <= 100000 and n + 1 not in visited:
        q.append((n + 1, depth + 1))
        visited.add(n + 1)
    if 0 <= n - 1 <= 100000 and n - 1 not in visited:
        q.append((n - 1, depth + 1))
        visited.add(n - 1)
    if 0 <= n * 2 <= 100000 and n * 2 not in visited:
        q.append((n * 2, depth + 1))
        visited.add(n * 2)