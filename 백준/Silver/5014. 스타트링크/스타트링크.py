import sys
from collections import deque

input = sys.stdin.readline

f, s, g, u, d = map(int, input().split())

visited = [0] * (f + 1)
cnt = 0
queue = deque()
visited[s] = True
queue.append(s)

while queue:
    n = len(queue)

    while n:
        n -= 1
        x = queue.popleft()
        if x == g:
            print(cnt)
            exit()
        up = x + u
        down = x - d

        if up <= f and not visited[up]:
            queue.append(up)
            visited[up] = True
        if down >= 1 and not visited[down]:
            queue.append(down)
            visited[down] = True
    cnt += 1
print("use the stairs")
