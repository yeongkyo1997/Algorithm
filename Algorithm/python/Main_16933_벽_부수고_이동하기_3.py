import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M, K = map(int, input().split())

arr = [list(map(int, list(input()))) for _ in range(N)]
visited = [[[False] * 11 for _ in range(M)] for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = collections.deque()
q.append((0, 0, 1, 0, False))
visited[0][0][0] = True

while q:
    x, y, depth, block, isNight = q.popleft()

    if x == N - 1 and y == M - 1:
        print(depth)
        exit()

    for i in range(4):
        nx, ny, ndepth = x + dx[i], y + dy[i], depth + 1

        if 0 <= nx < N and 0 <= ny < M:
            if isNight:
                if arr[nx][ny] == 1:
                    if block + 1 <= K:
                        if not visited[nx][ny][block + 1]:
                            q.append((x, y, ndepth, block, False))
                else:
                    if not visited[nx][ny][block]:
                        visited[nx][ny][block] = True
                        q.append((nx, ny, ndepth, block, False))
            else:
                if arr[nx][ny] == 1:
                    if block + 1 <= K:
                        if not visited[nx][ny][block + 1]:
                            visited[nx][ny][block + 1] = True
                            q.append((nx, ny, ndepth, block + 1, True))
                else:
                    if not visited[nx][ny][block]:
                        visited[nx][ny][block] = True
                        q.append((nx, ny, ndepth, block, True))
print(-1)
