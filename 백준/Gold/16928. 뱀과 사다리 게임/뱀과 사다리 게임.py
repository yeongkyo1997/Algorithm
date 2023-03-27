import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
visited = [False] * 101

ladder = collections.defaultdict()
snake = collections.defaultdict()
for _ in range(N):
    a, b = map(int, input().split())
    ladder[a] = b

for _ in range(M):
    a, b = map(int, input().split())
    snake[a] = b

queue = collections.deque()

queue.append((1, 0))

while queue:
    x, depth = queue.popleft()
    if x == 100:
        print(depth)
        break
    for i in range(6, 0, -1):
        nx = x + i
        if (0 > nx or nx > 100) or visited[nx]:
            continue
        if nx in snake.keys():
            queue.append((snake[nx], depth + 1))
            visited[snake[nx]] = True
        elif nx in ladder.keys():
            queue.append((ladder[nx], depth + 1))
            visited[ladder[nx]] = True
        else:
            queue.append((nx, depth + 1))
            visited[nx] = True