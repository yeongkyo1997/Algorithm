import collections
import math
import sys


# 활성화 시킬 바이러스 선택하기
def dfs(path, depth, start):
    global result
    if depth == M:
        active_virus = []
        visited = [[False] * N for _ in range(N)]

        # 바이러스 활성화 시키기
        for px, py in path:
            active_virus.append((px, py, 0))
            visited[px][py] = True

        # 활성화 시킨 바이러스 퍼뜨리기
        q = collections.deque(active_virus)
        zero_cnt = len(zero_points)
        while q:
            x, y, depth = q.popleft()

            for dx, dy in dir:
                nx, ny = x + dx, y + dy

                if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and board[nx][ny] in (0, 2):
                    visited[nx][ny] = True
                    q.append((nx, ny, depth + 1))
                    if board[nx][ny] == 0:
                        zero_cnt -= 1

                    if zero_cnt == 0:
                        result = min(result, depth + 1)
                        return

        return

    for i in range(start, len(virus)):
        path.append(virus[i])
        dfs(path, depth + 1, i + 1)
        path.pop()


if __name__ == '__main__':
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    N, M = map(int, input().split())

    board = [list(map(int, input().split())) for _ in range(N)]

    # 0의 좌표
    zero_points = []
    # 비활성 바이러스의 좌표
    virus = []
    result = math.inf
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                zero_points.append((i, j))
            if board[i][j] == 2:
                virus.append((i, j))

    dfs([], 0, 0)
    if result == math.inf:
        result = -1
    if not zero_points:
        result = 0
    print(result)