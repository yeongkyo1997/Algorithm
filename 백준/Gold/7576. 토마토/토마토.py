import sys
from collections import deque

input = sys.stdin.readline

col, row = map(int, input().split())
arr = []


def bfs(xy):
    dx = [-1, 1, 0, 0, ]
    dy = [0, 0, 1, -1]

    res = 0

    while queue:
        cx, cy, cday = queue.popleft()

        for i in range(4):
            nx, ny, nday = cx + dx[i], cy + dy[i], cday + 1

            if 0 <= nx < row and 0 <= ny < col and arr[nx][ny] == 0:
                res = max(res, nday)
                queue.append((nx, ny, nday))
                arr[nx][ny] = 1
    return res


for i in range(row):
    arr.append(list(map(int, input().split())))

result = 0
queue = deque()

for i in range(row):
    for j in range(col):
        if arr[i][j] == 1:
            queue.append((i, j, 0))

result = bfs(queue)
for i in range(row):
    for j in range(col):
        if arr[i][j] == 0:
            print(-1)
            exit()

print(result)
