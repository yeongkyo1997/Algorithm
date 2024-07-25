import collections

N = 16
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs(x, y):
    visited = set()
    q = collections.deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()
        if board[x][y] == 3:
            return True

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < N:
                if board[nx][ny] != 1 and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    q.append((nx, ny))

    return False


for _ in range(10):
    t = int(input())
    board = [list(map(int, str(input()))) for _ in range(N)]

    x, y = 0, 0

    for i in range(N):
        for j in range(N):
            if board[i][j] == 2:
                x, y = i, j

    if bfs(x, y):
        print(f'#{t} {1}')
    else:
        print(f'#{t} {0}')
