from collections import deque
import sys


def input(): return sys.stdin.readline().rstrip()


def move(x, y, dx, dy, board):
    cnt = 0
    while board[x + dx][y + dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt


def bfs(board, N, M):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(N):
        for j in range(M):
            if board[i][j] == 'R':
                rx, ry = i, j
            if board[i][j] == 'B':
                bx, by = i, j

    q = deque()
    q.append((rx, ry, bx, by, 1))

    visited = []
    visited.append((rx, ry, bx, by))

    while q:
        rx, ry, bx, by, depth = q.popleft()

        if depth > 10:
            break

        for i in range(4):
            nrx, nry, r_cnt = move(rx, ry, dx[i], dy[i], board)
            nbx, nby, b_cnt = move(bx, by, dx[i], dy[i], board)

            if board[nbx][nby] != 'O':
                if board[nrx][nry] == 'O':
                    return depth

                if nrx == nbx and nry == nby:
                    if r_cnt > b_cnt:
                        nrx -= dx[i]
                        nry -= dy[i]
                    else:
                        nbx -= dx[i]
                        nby -= dy[i]

                if (nrx, nry, nbx, nby) not in visited:
                    visited.append((nrx, nry, nbx, nby))
                    q.append((nrx, nry, nbx, nby, depth + 1))

    return -1


N, M = map(int, input().split())
board = [input()for _ in range(N)]

print(bfs(board, N, M))