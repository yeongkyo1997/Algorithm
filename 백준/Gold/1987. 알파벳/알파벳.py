import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]

result = 0


def bfs(x, y):
    global result
    q = {(x, y, arr[x][y])}

    while q:
        x, y, depth = q.pop()
        result = max(result, len(depth))

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C and arr[nx][ny] not in depth:
                q.add((nx, ny, depth + arr[nx][ny]))


bfs(0, 0)
print(result)