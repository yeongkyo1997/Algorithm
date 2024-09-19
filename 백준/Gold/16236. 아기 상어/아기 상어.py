import collections
import sys

# 상어 움직이기
def move(x, y):
    global sx, sy, eat, size
    candi = []
    q = collections.deque()
    dist = float('inf')
    q.append((x, y, 0))
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True

    while q:
        x, y, depth = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and board[nx][ny] <= size:
                visited[nx][ny] = True

                # 크기가 같은 물고기이거나 0이라면
                if board[nx][ny] == size or board[nx][ny] == 0:
                    # 먹을 수 없음, 이동만 가능
                    q.append((nx, ny, depth + 1))
                else:
                    # 먹을 수 있는 후보에 추가 후 더 이상 움직이지 않아도 됨
                    candi.append((nx, ny, depth + 1))

    candi.sort(key=lambda x: (x[2], x[0], x[1]))

    # 움직일 수 있다면
    if candi:
        # 움직이기
        x, y, depth = candi[0]
        sx, sy = x, y
        eat += 1
        board[x][y] = 0
        if eat == size:
            eat = 0
            size += 1
        return depth
    else:
        return 0


if __name__ == '__main__':
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    sx, sy = -1, -1
    size = 2
    eat = 0

    for i in range(N):
        for j in range(N):
            if board[i][j] == 9:
                sx, sy = i, j
                board[i][j] = 0

    result = 0
    while True:
        val = move(sx, sy)
        if val == 0:
            break
        else:
            result += val

    print(result)