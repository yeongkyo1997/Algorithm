from collections import deque


def solve(board):
    N = len(board)
    M = len(board[0])

    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    def move(x, y, dx, dy):
        count = 0
        while board[x + dx][y + dy] != '#' and board[x][y] != 'O':
            x += dx
            y += dy
            count += 1
        return x, y, count

    for i in range(N):
        for j in range(M):
            if board[i][j] == 'R':
                rx, ry = i, j
            if board[i][j] == 'B':
                bx, by = i, j

    queue = deque([(rx, ry, bx, by, 0)])
    visited = {rx, ry, bx, by}

    while queue:
        rx, ry, bx, by, depth = queue.popleft()

        if depth >= 10:
            return -1

        for dx, dy in directions:
            nrx, nry, red_moves = move(rx, ry, dx, dy)
            nbx, nby, blue_moves = move(bx, by, dx, dy)

            if board[nbx][nby] == 'O':
                continue
            if board[nrx][nry] == 'O':
                return depth + 1

            if (nrx, nry) == (nbx, nby):
                if red_moves > blue_moves:
                    nrx -= dx
                    nry -= dy
                else:
                    nbx -= dx
                    nby -= dy

            if (nrx, nry, nbx, nby) not in visited:
                visited.add((nrx, nry, nbx, nby))
                queue.append((nrx, nry, nbx, nby, depth + 1))

    return -1


N, M = map(int, input().rstrip().split())
board = [list(input()) for _ in range(N)]
print(solve(board))