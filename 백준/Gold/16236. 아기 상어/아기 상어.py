import collections
import sys

# 먹을 물고기 찾기
def bfs(x, y):
    global sx, sy, eat, shark_size
    dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    q = collections.deque()
    q.append((x, y, 0))
    visited = [[False] * N for _ in range(N)]
    candi = []

    while q:
        x, y, depth = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                visited[nx][ny] = True
                if board[nx][ny] > shark_size:
                    continue

                q.append((nx, ny, depth + 1))
                if 0 < board[nx][ny] < shark_size:
                    candi.append((depth + 1, nx, ny))
    if not candi:
        return -1

    candi.sort()
    time, sx, sy = candi[0]
    board[sx][sy] = 0
    eat += 1
    if eat == shark_size:
        shark_size += 1
        eat = 0

    return time


if __name__ == '__main__':
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    # 현재 상어의 크기
    shark_size = 2

    # 현재 먹은 물고기
    eat = 0

    # 현재 상어의 위치
    sx, sy = -1, -1
    for i in range(N):
        for j in range(N):
            if board[i][j] == 9:
                sx, sy = i, j
                board[i][j] = 0
                break
        else:
            continue
        break

    result = 0
    # 먹을 수 있는 상어 찾기
    while True:
        time = bfs(sx, sy)
        if time == -1:
            break
        else:
            result += time
    print(result)