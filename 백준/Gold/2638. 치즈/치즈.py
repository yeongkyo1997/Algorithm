import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def melting():
    melt_cnt = [[0] * M for _ in range(N)]
    q = collections.deque()
    q.append((0, 0))
    visited = [[False] * M for _ in range(N)]
    visited[0][0] = True

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if board[nx][ny] == 1:
                    melt_cnt[nx][ny] += 1
                else:
                    visited[nx][ny] = True
                    q.append((nx, ny))

    for i in range(N):
        for j in range(M):
            if melt_cnt[i][j] >= 2:
                board[i][j] = 0
                global cheese_cnt
                cheese_cnt -= 1


if __name__ == '__main__':
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    N, M = map(int, input().split())
    cheese_cnt = 0
    board = [list(map(int, input().split())) for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                cheese_cnt += 1

    result = 0
    while True:
        if cheese_cnt == 0:
            break
        melting()
        result += 1
    print(result)