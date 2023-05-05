import sys

input = lambda: sys.stdin.readline().rstrip()

R, C = map(int, input().split())
MAP = [list(input()) for _ in range(R)]
visited = [False] * 26
result = 0

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y, cnt):
    global result
    result = max(result, cnt)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < R and 0 <= ny < C:
            if not visited[ord(MAP[nx][ny]) - ord('A')]:
                visited[ord(MAP[nx][ny]) - ord('A')] = True
                dfs(nx, ny, cnt + 1)
                visited[ord(MAP[nx][ny]) - ord('A')] = False


visited[ord(MAP[0][0]) - ord('A')] = True
dfs(0, 0, 1)

print(result)