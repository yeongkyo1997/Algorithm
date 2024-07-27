import collections
import math

N, M = map(int, input().rstrip().split())
ladders = {}
snakes = {}

for _ in range(N):
    x, y = map(int, input().rstrip().split())
    ladders[x] = y

for _ in range(M):
    u, v = map(int, input().rstrip().split())
    snakes[u] = v


def bfs():
    q = collections.deque()
    q.append((1, 0))
    visited = collections.defaultdict(lambda: math.inf)
    visited[1] = 0

    while q:
        cur, depth = q.popleft()
        if cur > 100:
            continue

        for i in range(1, 7):
            n_pos = cur + i

            if n_pos in ladders:
                n_pos = ladders[n_pos]
            if n_pos in snakes:
                n_pos = snakes[n_pos]

            if visited[n_pos] > depth + 1:
                visited[n_pos] = depth + 1
                q.append((n_pos, depth + 1))

            if n_pos == 100:
                return depth + 1


print(bfs())